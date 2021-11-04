package org.example;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.example.utils.StringUtils;

public class ClassWriter {
  private String outputPath;
  private FileOutputStream fileOutputStream;
  private BufferedOutputStream bufferedOutputStream;

  public ClassWriter(String outputPath) {
    this.outputPath = outputPath;

    // 以下の処理はここではなくて別メソッドの方が良いかも
    try {
      this.fileOutputStream = new FileOutputStream(this.outputPath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    this.bufferedOutputStream = new BufferedOutputStream(this.fileOutputStream);

    try {
      // magic
      byte[] magic = {(byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE };
      this.bufferedOutputStream.write(magic);

      // minor_version
      byte[] minorVersion = {(byte)0x00, (byte)0x00 };
      this.bufferedOutputStream.write(minorVersion);
      // major_version
      // 61 = java17
      byte[] majorVersion = {(byte)0, (byte)61};
      this.bufferedOutputStream.write(majorVersion);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      if (this.bufferedOutputStream != null) {
        this.bufferedOutputStream.close();
      }
      if (this.fileOutputStream != null) {
        this.fileOutputStream.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

}
