package org.example.vm;

public enum ClassAccessFlags {
  PUBLIC("0x001"),
  SUPER("0x0020");

  private String value;

  ClassAccessFlags(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
