package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.example.tokens.KeyWord;
import org.example.tokens.Symbol;
import org.example.tokens.TokenType;
import org.example.utils.NumberUtils;

public class JavaTokenizer {
  private List<String> tokens = new ArrayList<>();
  private int pointer = 0;

  public JavaTokenizer(Path filePath) {
    try (BufferedReader reader = Files.newBufferedReader(filePath)) {
      while (true) {
        String line = reader.readLine();

        // 終端判定
        if (line == null) {
          break;
        }
        line = line.trim();
        int readPoint = 0;
        StringBuilder tmpToken = new StringBuilder();
        // MEMO: なんかいまいちだから後で直したい
        while (readPoint < line.length()) {
          char readChar = line.charAt(readPoint);

          switch (readChar) {
            case ' ':
              ifTokenThenAdd(tmpToken.toString());
              tmpToken = new StringBuilder();
              break;
            case ';' :
              ifTokenThenAdd(tmpToken.toString());
              tmpToken = new StringBuilder();
              break;
            case '(' :
              ifTokenThenAdd(tmpToken.toString());
              tmpToken = new StringBuilder();
              break;
            case ')' :
              ifTokenThenAdd(tmpToken.toString());
              tmpToken = new StringBuilder();
              break;
            case '{' :
              ifTokenThenAdd(tmpToken.toString());
              tmpToken = new StringBuilder();
              break;
            case '}' :
              ifTokenThenAdd(tmpToken.toString());
              tmpToken = new StringBuilder();
              break;
            default:
              break;
          }
          tmpToken.append(readChar);
          readPoint++;
        }
        ifTokenThenAdd(tmpToken.toString());
      }
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private void ifTokenThenAdd(String token) {
    if (!token.isEmpty() && !token.trim().equals("")) {
      tokens.add(token.trim());
    }
  }

  public Boolean hasMoreTokens() {
    return (pointer < this.tokens.size());
  }

  public void advance() {
    if (hasMoreTokens()) pointer++;
  }

  public TokenType tokenType() {
    String token = this.tokens.get(pointer);
    if (KeyWord.isKeyword(token)) {
      return TokenType.KEYWORD;
    }
    if (Symbol.isSymbol(token)) {
      return TokenType.SYMBOL;
    }
    if (NumberUtils.isNumeric(token)) {
      return TokenType.INT_CONSTANT;
    }
    if (token.startsWith("\"") && token.endsWith("\"")) {
      return TokenType.STRING_CONSTANT;
    }
    return TokenType.IDENTIFIER;
  }

  public String keyword() {
    if (tokenType() != TokenType.KEYWORD) {
      throw new RuntimeException("only when type of token is 'KEYWORD' can keyword()");
    }
    return this.tokens.get(pointer);
  }

  public String symbol() {
    if (tokenType() != TokenType.SYMBOL) {
      throw new RuntimeException("only when type of token is 'SYMBOL' can symbol()");
    }
    return this.tokens.get(pointer);
  }

  public String identifier() {
    if (tokenType() != TokenType.IDENTIFIER) {
      throw new RuntimeException("only when type of token is 'IDENTIFIER' can identifier()");
    }
    return this.tokens.get(pointer);
  }

  public int intVal() {
    if (tokenType() != TokenType.INT_CONSTANT) {
      throw new RuntimeException("only when type of token is 'INT_CONSTANT' can intVal()");
    }
    return Integer.parseInt(this.tokens.get(pointer));
  }

  public String stringVal() {
    if (tokenType() != TokenType.STRING_CONSTANT) {
      throw new RuntimeException("only when type of token is 'STRING_CONSTANT' can stringVal()");
    }
    return this.tokens.get(pointer).replace("\"", "");
  }

}
