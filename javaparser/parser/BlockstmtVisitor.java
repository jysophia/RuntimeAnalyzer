import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;

import java.util.ArrayList;
import java.util.List;

public class BlockstmtVisitor extends ModifierVisitor<Void> {
  @Override
  public BlockStmt visit(BlockStmt bs, Void arg) {
    super.visit(bs, arg);
    addReturnLogging(bs);

    return bs;
  }

  private void addReturnLogging(BlockStmt bs) {
    List<Statement> existingStatements = bs.getStatements();
    List<Integer> returnIndexes = new ArrayList<>();
    for (int i = 0; i < existingStatements.size(); i++) {
      if (existingStatements.get(i).isReturnStmt()) {
        returnIndexes.add(i);
      }
    }
    returnIndexes.forEach(i -> {
      addReturnAtIndex(bs, i);
    });
  }

  public void addReturnAtIndex(BlockStmt bs, Integer index) {
    List<Statement> statements = new ArrayList<>();

    statements.add(StaticJavaParser.parseStatement("long returnNanos = System.nanoTime();"));
    statements.add(StaticJavaParser.parseStatement("long duration = returnNanos - callNanos;"));
    statements.add(StaticJavaParser.parseStatement("ReturnTelemetry returnTelemetry = new ReturnTelemetry(objectId, methodName, type, returnNanos, duration);"));
    statements.add(StaticJavaParser.parseStatement("TelemetryLogger.logReturn(returnTelemetry);"));

    List<Statement> existingStatements = bs.getStatements();
    for (int i = 0; i < statements.size(); i++) {
      existingStatements.add(i + index, statements.get(i));
    }
  }
}
