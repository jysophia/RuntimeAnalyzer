package com.yourorganization.maven_sample;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.utils.CodeGenerationUtils;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Some code that uses JavaParser.
 */
public class Printerize {
    public static void main(String[] args) {
        // JavaParser has a minimal logging class that normally logs nothing.
        // Let's ask it to write to standard out:
        Log.setAdapter(new Log.StandardOutStandardErrorAdapter());
        
        // SourceRoot is a tool that read and writes Java files from packages on a certain root directory.
        // In this case the root directory is found by taking the root from the current Maven module,
        // with src/main/resources appended.
        SourceRoot sourceRoot = new SourceRoot(CodeGenerationUtils.mavenModuleRoot(Printerize.class).resolve("src/main/resources"));
        MethodDeclarationVisitor mdv = new MethodDeclarationVisitor();

        try {
            List<ParseResult<CompilationUnit>> results = sourceRoot.tryToParse();
            for (ParseResult<CompilationUnit> result : results) {
                if (result.isSuccessful()) {
                    CompilationUnit cu = result.getResult().get();
                    mdv.visit(cu, null);
                    cu.addImport("PrinterTools.SimplePrinter");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // This saves all the files we just read to an output directory.  
        sourceRoot.saveAll(
                // The path of the Maven module/project which contains the LogicPositivizer class.
                CodeGenerationUtils.mavenModuleRoot(Printerize.class)
                        // appended with a path to "output"
                        .resolve(Paths.get("output")));
    }
}
