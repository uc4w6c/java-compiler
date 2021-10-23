package org.example;

import java.nio.file.Path;

import org.example.tokens.TokenType;

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
      while (this.jackTokenizer.hasMoreTokens()) {
        TokenType tokenType = this.jackTokenizer.tokenType();
        if (tokenType == TokenType.KEYWORD) {
          System.out.print("<keyword>");
          System.out.print(this.jackTokenizer.keyword());
          System.out.println("</keyword>");
        }
        if (tokenType == TokenType.SYMBOL) {
          System.out.print("<symbol>");
          System.out.print(this.jackTokenizer.symbol());
          System.out.println("</symbol>");
        }
        if (tokenType == TokenType.IDENTIFIER) {
          System.out.print("<identifier>");
          System.out.print(this.jackTokenizer.identifier());
          System.out.println("</identifier>");
        }
        if (tokenType == TokenType.INT_CONSTANT) {
          System.out.print("<int_constant>");
          System.out.print(this.jackTokenizer.intVal());
          System.out.println("</int_constant>");
        }
        if (tokenType == TokenType.STRING_CONSTANT) {
          System.out.print("<string_constant>");
          System.out.print(this.jackTokenizer.stringVal());
          System.out.println("</string_constant>");
        }
        this.jackTokenizer.advance();
      }
    }
}
