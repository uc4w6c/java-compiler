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
      String line = reader.readLine().trim();
      while (true) {
        // 終端判定
        if (line.isEmpty()) {

        }
        int readStartPoint = 0;
        int readCount = 0;
        String tmpToken;
        while (readStartPoint + readCount < line.length()) {
          char readChar = line.charAt(readStartPoint + readCount);
          switch (readChar) {
            case ' ':
              readCount = 0;
            case ';' :
              readCount = 0;
            case '(' :
              readCount = 0;
            case ')' :
              readCount = 0;
            case '{' :
              readCount = 0;
            case '}' :
              readCount = 0;
            default:
          }
        }
      }

    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }


}
