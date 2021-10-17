package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JavaTokenizer {
  private List<String> tokens = new ArrayList<>();
  private int pointer = 0;

  public JavaTokenizer(Path filePath) {
    try (BufferedReader reader = Files.newBufferedReader(filePath)) {
      while (true) {
        String line = reader.readLine().trim();

        // 終端判定
        if (line.isEmpty()) {
          break;
        }
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
        }
        ifTokenThenAdd(tmpToken.toString());
      }
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private void ifTokenThenAdd(String token) {
    if (!token.isEmpty() && !token.trim().equals("")) {
      tokens.add(token);
    }
  }

  public Boolean hasMoreTokens() {
    return (pointer < this.tokens.size());
  }

}
