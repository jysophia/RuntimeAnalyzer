import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;

import java.util.ArrayList;
import java.util.List;

public class MethodDeclarationVisitor extends ModifierVisitor<Void> {
  @Override
  public MethodDeclaration visit(MethodDeclaration md, Void arg) {
    super.visit(md, arg);
    String methodName = md.getNameAsString();
    if (md.isStatic()) {
      if (methodName.equals("main")) {
        handleMain(md);
      }
      return md;
    }

    addCallLogging(md);
    if (md.getType().asString().equals("void")) {
      addReturnAtIndex(md, md.getBody().get().getStatements().size());
    } else {
      addReturnLogging(md);
    }

    return md;
  }

  private void addReturnLogging(MethodDeclaration md) {
    List<Statement> existingStatements = md.getBody().get().getStatements();
    List<Integer> returnIndexes = new ArrayList<>();
    for (int i = 0; i < existingStatements.size(); i++) {
      if (existingStatements.get(i).isReturnStmt()) {
        returnIndexes.add(i);
      }
    }
    returnIndexes.forEach(i -> {
      addReturnAtIndex(md, i);
    });
  }

  private void addReturnAtIndex(MethodDeclaration md, Integer index) {
    List<Statement> statements = new ArrayList<>();

    statements.add(StaticJavaParser.parseStatement("long returnNanos = System.nanoTime();"));
    statements.add(StaticJavaParser.parseStatement("long duration = returnNanos - callNanos;"));
    statements.add(StaticJavaParser.parseStatement("ReturnTelemetry returnTelemetry = new ReturnTelemetry(objectId, methodName, type, returnNanos, duration);"));
    statements.add(StaticJavaParser.parseStatement("TelemetryLogger.logReturn(returnTelemetry);"));

    List<Statement> existingStatements = md.getBody().get().getStatements();
    for (int i = 0; i < statements.size(); i++) {
      existingStatements.add(i + index, statements.get(i));
    }
  }

  private void addCallLogging(MethodDeclaration md) {
    List<Statement> statements = new ArrayList<>();

    statements.add(StaticJavaParser.parseStatement("int objectId = this.hashCode();"));
    statements.add(StaticJavaParser.parseStatement("String methodName = (\"" + md.getNameAsString() + "\");"));
    statements.add(StaticJavaParser.parseStatement("String type = this.getClass().getName();"));
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
