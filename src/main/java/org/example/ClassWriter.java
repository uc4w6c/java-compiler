package org.example;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.example.utils.StringUtils;
import org.example.vm.ClassAccessFlags;

public class ClassWriter {
  private String outputPath;
  private List<ClassAccessFlags> classAccessFlagsList = new ArrayList<>();
  private String className = null;
  private String superClass = null;
  // MEMO: interfaceとfieldは今回は実装しない

  public ClassWriter(String outputPath) {
    this.outputPath = outputPath;
  }

  /** アクセスフラグを追加 */
  public void addClassAccessFlags(ClassAccessFlags classAccessFlags) {
    classAccessFlagsList.add(classAccessFlags);
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public void setSuperClass(String superClass) {
    this.superClass = superClass;
  }

  public void write() {
    try(FileOutputStream fileOutputStream = new FileOutputStream(this.outputPath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);) {

      // magic
      byte[] magic = {(byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE };
      bufferedOutputStream.write(magic);

      // minor_version
      byte[] minorVersion = {(byte)0x00, (byte)0x00 };
      bufferedOutputStream.write(minorVersion);
      // major_version
      // 61 = java17
      byte[] majorVersion = {(byte)0, (byte)61};
      bufferedOutputStream.write(majorVersion);

    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
