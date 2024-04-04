import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;

import java.util.ArrayList;
import java.util.List;

public class BlockstmtVisitor extends ModifierVisitor<MethodDeclaration> {
  @Override
  public BlockStmt visit(BlockStmt bs, MethodDeclaration md) {
    super.visit(bs, md);
    addReturnLogging(bs, md);

    return bs;
  }

  private void addReturnLogging(BlockStmt bs, MethodDeclaration md) {
    List<Statement> existingStatements = bs.getStatements();
    List<Integer> returnIndexes = new ArrayList<>();
    for (int i = 0; i < existingStatements.size(); i++) {
      if (existingStatements.get(i).isReturnStmt()) {
        returnIndexes.add(i);
      }
    }
    returnIndexes.forEach(i -> {
      addReturnAtIndex(bs, i, md);
    });
  }

  public void addReturnAtIndex(BlockStmt bs, Integer index, MethodDeclaration md) {
    List<Statement> statements = new ArrayList<>();

    statements.add(StaticJavaParser.parseStatement("long _returnNanos_ = System.nanoTime();"));
    statements.add(StaticJavaParser.parseStatement("long _duration_ = _returnNanos_ - _callNanos_;"));
    statements.add(StaticJavaParser.parseStatement("ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_);"));
    statements.add(StaticJavaParser.parseStatement("TelemetryLogger.logReturn(_returnTelemetry_);"));

    if (md.getNameAsString().equals("main") && md.isStatic()) {
      statements.add(StaticJavaParser.parseStatement("TelemetryLogger.dumpLogs();"));
    }

    List<Statement> existingStatements = bs.getStatements();
    for (int i = 0; i < statements.size(); i++) {
      existingStatements.add(i + index, statements.get(i));
    }
  }
}
