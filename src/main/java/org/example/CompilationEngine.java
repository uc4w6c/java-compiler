package org.example;

import java.nio.file.Path;

import org.example.tokens.KeyWord;
import org.example.tokens.Symbol;
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
        this.compileClass();
        this.jackTokenizer.advance();
      }
    }

    /** クラスコンパイル */
    private void compileClass() {
      // class
      System.out.println("<class>");

      if (this.jackTokenizer.tokenType() != TokenType.KEYWORD) {
        throw new RuntimeException("lack 'class' token");
      }
      // public, private, protected
      if (this.jackTokenizer.keyword().equals(KeyWord.PUBLIC.getCode())) {
        System.out.println("<keyword>");
        System.out.println(this.jackTokenizer.keyword());
        System.out.println("</keyword>");
        this.jackTokenizer.advance();
      }

      // class
      if (!this.jackTokenizer.keyword().equals(KeyWord.CLASS.getCode())) {
        throw new RuntimeException("lack 'class' token");
      }
      System.out.println("<keyword>");
      System.out.println(this.jackTokenizer.keyword());
      System.out.println("</keyword>");
      this.jackTokenizer.advance();

      // className
      if (this.jackTokenizer.tokenType() != TokenType.IDENTIFIER) {
        throw new RuntimeException("expect an identifier after 'class'");
      }
      System.out.println("<identifier>");
      System.out.println(this.jackTokenizer.identifier());
      System.out.println("</identifier>");
      this.jackTokenizer.advance();

      // '{'
      if (!(this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
            this.jackTokenizer.symbol() == Symbol.LBRACE.getCode())) {
        throw new RuntimeException("expect '{' after className");
      }
      System.out.println("<symbol>");
      System.out.println(this.jackTokenizer.symbol());
      System.out.println("</symbol>");
      this.jackTokenizer.advance();

      // methods
      this.compileMethods();

      // '}'
      if (!(this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
          this.jackTokenizer.symbol() == Symbol.RBRACE.getCode())) {
        throw new RuntimeException("expect '}' after '{'");
      }
      System.out.println("<symbol>");
      System.out.println(this.jackTokenizer.symbol());
      System.out.println("</symbol>");
      this.jackTokenizer.advance();

      System.out.println("</class>");
    }

    /** メソッドコンパイル */
    private void compileMethods() {
      while (true) {
        // classの終了 '}' まで
        if (!(this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
            this.jackTokenizer.symbol() == Symbol.RBRACE.getCode())) {
          break;
        }

        System.out.println("<method>");

        // public, private, protected
        if (this.jackTokenizer.keyword().equals(KeyWord.PUBLIC.getCode())) {
          System.out.println("<keyword>");
          System.out.println(this.jackTokenizer.keyword());
          System.out.println("</keyword>");
          this.jackTokenizer.advance();
        }

        // static
        if (this.jackTokenizer.keyword().equals(KeyWord.STATIC.getCode())) {
          System.out.println("<keyword>");
          System.out.println(this.jackTokenizer.keyword());
          System.out.println("</keyword>");
          this.jackTokenizer.advance();
        }

        // method return value
        // TODO: 一旦プリミティブのみ許可にする
        if (this.jackTokenizer.tokenType() != TokenType.KEYWORD &&
              (this.jackTokenizer.keyword() != KeyWord.VOID.getCode() ||
                  this.jackTokenizer.keyword() != KeyWord.INT.getCode() ||
                  this.jackTokenizer.keyword() != KeyWord.BOOLEAN.getCode() ||
                  this.jackTokenizer.keyword() != KeyWord.CHAR.getCode())) {
          throw new RuntimeException("lack 'return value' token");
        }
        System.out.println("<keyword>");
        System.out.println(this.jackTokenizer.keyword());
        System.out.println("</keyword>");
        this.jackTokenizer.advance();

        // methodName
        if (this.jackTokenizer.tokenType() != TokenType.IDENTIFIER) {
          throw new RuntimeException("lack 'method name' token");
        }
        System.out.println("<identifier>");
        System.out.println(this.jackTokenizer.identifier());
        System.out.println("</identifier>");
        this.jackTokenizer.advance();

        // '{'
        if (!(this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
            this.jackTokenizer.symbol() == Symbol.LPAREN.getCode())) {
          throw new RuntimeException("expect '(' after methodName");
        }
        System.out.println("<symbol>");
        System.out.println(this.jackTokenizer.symbol());
        System.out.println("</symbol>");
        this.jackTokenizer.advance();

        // parameter List
        while (true) {
          if (!(this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
              this.jackTokenizer.symbol() == Symbol.RPAREN.getCode())) {
            break;
          }
          // parameter
          // TODO: 一旦プリミティブのみ許可にする
          if (this.jackTokenizer.tokenType() != TokenType.KEYWORD &&
              (this.jackTokenizer.keyword() != KeyWord.VOID.getCode() ||
                  this.jackTokenizer.keyword() != KeyWord.INT.getCode() ||
                  this.jackTokenizer.keyword() != KeyWord.BOOLEAN.getCode() ||
                  this.jackTokenizer.keyword() != KeyWord.CHAR.getCode())) {
            throw new RuntimeException("lack 'return value' token");
          }
          System.out.println("<keyword>");
          System.out.println(this.jackTokenizer.keyword());
          System.out.println("</keyword>");
          this.jackTokenizer.advance();

          // parameterName
          if (this.jackTokenizer.tokenType() != TokenType.IDENTIFIER) {
            throw new RuntimeException("lack 'parameter name' token");
          }
          System.out.println("<identifier>");
          System.out.println(this.jackTokenizer.identifier());
          System.out.println("</identifier>");
          this.jackTokenizer.advance();

          if (this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
            this.jackTokenizer.tokenType().equals(Symbol.COMMA.getCode())
          ) {
            System.out.println("<symbol>");
            System.out.println(this.jackTokenizer.keyword());
            System.out.println("</symbol>");
            this.jackTokenizer.advance();
          }
        }

        // ')'
        System.out.println("<symbol>");
        System.out.println(this.jackTokenizer.symbol());
        System.out.println("</symbol>");
        this.jackTokenizer.advance();

        // '{'
        if (!(this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
            this.jackTokenizer.symbol() == Symbol.LBRACE.getCode())) {
          throw new RuntimeException("expect '{' after method");
        }
        System.out.println("<symbol>");
        System.out.println(this.jackTokenizer.symbol());
        System.out.println("</symbol>");
        this.jackTokenizer.advance();

        // method内部


        // '}'
        if (!(this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
            this.jackTokenizer.symbol() == Symbol.RBRACE.getCode())) {
          throw new RuntimeException("expect '}' after '{'");
        }
        System.out.println("<symbol>");
        System.out.println(this.jackTokenizer.symbol());
        System.out.println("</symbol>");
        this.jackTokenizer.advance();

        System.out.println("</method>");
      }
    }

    /** メソッド内部 */
    private void methodBody() {
      while (true) {
        // classの終了 '}' まで
        if (!(this.jackTokenizer.tokenType() == TokenType.SYMBOL &&
            this.jackTokenizer.symbol() == Symbol.RBRACE.getCode())) {
          return;
        }

        

      }
    }
}
