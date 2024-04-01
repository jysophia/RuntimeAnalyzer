import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;

import java.util.List;

public class MethodDeclarationVisitor extends ModifierVisitor<Void> {
  @Override
  public MethodDeclaration visit(MethodDeclaration md, Void arg) {
    super.visit(md, arg);

    String methodName = md.getNameAsString();
    Statement s = StaticJavaParser.parseStatement("SimplePrinter.printString(\"" + methodName + "\");");
    List<Statement> statements = md.getBody().get().getStatements();
    statements.add(0, s);

    return md;
  }
}
