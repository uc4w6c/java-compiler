package org.example;

import java.nio.file.Path;

public class CompilationEngine {
    private Path inputPath;
    private Path outPath;
    private JavaTokenizer jackTokenizer;

    public CompilationEngine(Path inputPath, Path outPath) {
        this.inputPath = inputPath;
        this.outPath = outPath;

        this.jackTokenizer = new JavaTokenizer(inputPath);
    }

    public void compile() {

    }
}
