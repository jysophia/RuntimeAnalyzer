import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

/**
 * Some code that uses JavaParser.
 */
public class AddTelemetry {
    public static void main(String[] args) {
        // JavaParser has a minimal logging class that normally logs nothing.
        // Let's ask it to write to standard out:
        Log.setAdapter(new Log.StandardOutStandardErrorAdapter());
        
        // SourceRoot is a tool that read and writes Java files from packages on a certain root directory.
        // In this case the root directory is found by taking the root from the current Maven module,
        // with src/main/resources appended.
        Path rootPath = FileSystems.getDefault().getPath("../resources");
        SourceRoot sourceRoot = new SourceRoot(rootPath);
        MethodDeclarationVisitor mdv = new MethodDeclarationVisitor();

        try {
            List<ParseResult<CompilationUnit>> results = sourceRoot.tryToParse();
            for (ParseResult<CompilationUnit> result : results) {
                if (result.isSuccessful()) {
                    CompilationUnit cu = result.getResult().get();
                    mdv.visit(cu, null);
                    cu.addImport("TelemetryTools.CallTelemetry");
                    cu.addImport("TelemetryTools.ReturnTelemetry");
                    cu.addImport("TelemetryTools.TelemetryLogger");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // This saves all the files we just read to an output directory.
        Path parsedCodePath = FileSystems.getDefault().getPath("../../parsedcode");
        sourceRoot.saveAll(parsedCodePath);
        /*
        sourceRoot.saveAll(
                // The path of the Maven module/project which contains the LogicPositivizer class.
                CodeGenerationUtils.mavenModuleRoot(Printerize.class)
                        // appended with a path to "output"
                        .resolve(Paths.get("output")));

         */
    }
}
