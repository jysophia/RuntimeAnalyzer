import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;

import java.util.ArrayList;
import java.util.List;

public class MethodDeclarationVisitor extends ModifierVisitor<Void> {


  @Override
  public MethodDeclaration visit(MethodDeclaration md, Void arg) {
    super.visit(md, arg);
    String methodName = md.getNameAsString();
    if (md.isStatic() && methodName.equals("main")) {
      handleMain(md);
      return md;
    }

    // visit all blocks in method and find returns to add return logging
    BlockstmtVisitor bsv = new BlockstmtVisitor();
    bsv.visit(md, null);

    addCallLogging(md);

    // if the visited method is return void type, then also add return logging at end
    if (md.getType().asString().equals("void")) {
      bsv.addReturnAtIndex(md.getBody().get(), md.getBody().get().getStatements().size());
    }

    return md;
  }

  private void addCallLogging(MethodDeclaration md) {
    List<Statement> statements = new ArrayList<>();

    if (md.isStatic()) {
      statements.add(StaticJavaParser.parseStatement("int objectId = 0;"));
      statements.add(StaticJavaParser.parseStatement("String type = \"static\";"));
    } else {
      statements.add(StaticJavaParser.parseStatement("int objectId = this.hashCode();"));
      statements.add(StaticJavaParser.parseStatement("String type = this.getClass().getName();"));
    }

    statements.add(StaticJavaParser.parseStatement("String methodName = (\"" + md.getNameAsString() + "\");"));
    statements.add(StaticJavaParser.parseStatement("long callNanos = System.nanoTime();"));
    statements.add(StaticJavaParser.parseStatement("CallTelemetry callTelemetry = new CallTelemetry(objectId, methodName, type, callNanos);"));
    statements.add(StaticJavaParser.parseStatement("TelemetryLogger.logCall(callTelemetry);"));

    List<Statement> existingStatements = md.getBody().get().getStatements();
    for (int i = 0; i < statements.size(); i++) {
      existingStatements.add(i, statements.get(i));
    }
  }

  private void handleMain(MethodDeclaration md) {
    // add call at end to dumpLogs
    Statement dumpLogs = StaticJavaParser.parseStatement("TelemetryLogger.dumpLogs();");
    List<Statement> existingStatements = md.getBody().get().getStatements();
    existingStatements.add(existingStatements.size(), dumpLogs);
  }
}
