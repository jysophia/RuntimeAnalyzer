import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;

import java.util.ArrayList;
import java.util.List;

public class MethodDeclarationVisitor extends ModifierVisitor<Void> {


  @Override
  public MethodDeclaration visit(MethodDeclaration md, Void arg) {
    super.visit(md, arg);

    // visit all blocks in method and find returns to add return logging
    BlockstmtVisitor bsv = new BlockstmtVisitor();
    bsv.visit(md, md);

    addCallLogging(md);

    // if the visited method is return void type, then also add return logging at end
    if (md.getType().asString().equals("void")) {
      bsv.addReturnAtIndex(md.getBody().get(), md.getBody().get().getStatements().size(), md);
    }

    return md;
  }

  private void addCallLogging(MethodDeclaration md) {
    List<Statement> statements = new ArrayList<>();
    addParameterLogging(md, statements);

    if (md.isStatic()) {
      statements.add(StaticJavaParser.parseStatement("int _objectId_ = 0;"));
      statements.add(StaticJavaParser.parseStatement("String _type_ = \"static\";"));
    } else {
      statements.add(StaticJavaParser.parseStatement("int _objectId_ = this.hashCode();"));
      statements.add(StaticJavaParser.parseStatement("String _type_ = this.getClass().getName();"));
    }

    statements.add(StaticJavaParser.parseStatement("String _methodName_ = (\"" + md.getNameAsString() + "\");"));
    statements.add(StaticJavaParser.parseStatement("long _callNanos_ = System.nanoTime();"));
    statements.add(StaticJavaParser.parseStatement("CallTelemetry _callTelemetry_ = new CallTelemetry(_objectId_, " +
            "_methodName_, _type_, _callNanos_, _paramTypes_, _paramNames_, _paramVals_);"));
    statements.add(StaticJavaParser.parseStatement("TelemetryLogger.logCall(_callTelemetry_);"));

    List<Statement> existingStatements = md.getBody().get().getStatements();
    for (int i = 0; i < statements.size(); i++) {
      existingStatements.add(i, statements.get(i));
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
