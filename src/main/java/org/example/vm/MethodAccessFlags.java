package org.example.vm;

public enum MethodAccessFlags {
  PUBLIC("0x001"),
  PRIVATE("0x0002"),
  STATIC("0x0008"),
  VARARGS("0x0080");

  private String value;

  MethodAccessFlags(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
