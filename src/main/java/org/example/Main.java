package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("引数を1つ入力してください");
    }
    String fileName = args[0];
    Path path = Paths.get(fileName);
    if (!Files.exists(path)) {
      throw new IllegalArgumentException("指定したファイルは存在しません\r\n" +
          "FileName:" + fileName);
    }

    if (!path.getFileName().toString().endsWith(".java")) {
      throw new IllegalArgumentException("javaのファイルを指定してください。\r\n" +
          "FileName:" + fileName);
    }

    Path outPath = path.getParent().resolve(path.getFileName().toString().replace(".java", ".class"));
    CompilationEngine compilationEngine = new CompilationEngine(path, outPath);
    compilationEngine.compile();
  }
}
