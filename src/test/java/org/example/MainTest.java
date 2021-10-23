package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import static java.nio.charset.StandardCharsets.UTF_8;

class MainTest {
  @TempDir
  Path tempDir;

  @Test
  void test() throws IOException {
    String input = """
                public class Hello {
                  public static void main(String[] args) {
                    System.out.println("Hello");
                  }
                }
                """;

    Path path = tempDir.resolve("Hello.java");
    Files.write(path, input.getBytes(UTF_8));

    Main.main(new String[] { path.toString() });
  }
}
