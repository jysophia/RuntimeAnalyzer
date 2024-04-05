import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
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
    addParameterLogging(md, statements);

    statements.add(StaticJavaParser.parseStatement("long _returnNanos_ = System.nanoTime();"));
    statements.add(StaticJavaParser.parseStatement("long _duration_ = _returnNanos_ - _callNanos_;"));
    statements.add(StaticJavaParser.parseStatement("ReturnTelemetry _returnTelemetry_ = new ReturnTelemetry(_objectId_, _methodName_, _type_, _returnNanos_, _duration_, _paramTypes_, _paramNames_, _paramVals_);"));
    statements.add(StaticJavaParser.parseStatement("TelemetryLogger.logReturn(_returnTelemetry_);"));

    if (md.getNameAsString().equals("main") && md.isStatic()) {
      Parameter args = md.getParameters().get(0);
      statements.add(StaticJavaParser.parseStatement("TelemetryLogger.logMainParams(" + args.getNameAsString() + ");"));
      statements.add(StaticJavaParser.parseStatement("TelemetryLogger.dumpLogs();"));
    }

    List<Statement> existingStatements = bs.getStatements();
    for (int i = 0; i < statements.size(); i++) {
      existingStatements.add(i + index, statements.get(i));
    }
  }

  private void addParameterLogging(MethodDeclaration md, List<Statement> statements) {
    statements.add(StaticJavaParser.parseStatement("List<String> _paramTypes_ = new ArrayList<>();"));
    statements.add(StaticJavaParser.parseStatement("List<String> _paramNames_ = new ArrayList<>();"));
    statements.add(StaticJavaParser.parseStatement("List<String> _paramVals_ = new ArrayList<>();"));

    NodeList<Parameter> params = md.getParameters();
    params.forEach(p -> {
      statements.add(StaticJavaParser.parseStatement("_paramTypes_.add(\"" + p.getType().toString() + "\");"));
      statements.add(StaticJavaParser.parseStatement("_paramNames_.add(\"" + p.getNameAsString() + "\");"));
      if (p.getType().isPrimitiveType()) {
        statements.add(StaticJavaParser.parseStatement("_paramVals_.add(String.valueOf(" + p.getNameAsString() + "));"));
      } else {
        statements.add(StaticJavaParser.parseStatement("_paramVals_.add(\"NonPrimitiveType\");"));
      }
    });
  }
}
