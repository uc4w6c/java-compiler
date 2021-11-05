package org.example.vm;

public enum DescriptorType {
  VOID("V"),
  CLASS();

  private String code;

  DescriptorType(String code) {
    this.code = code;
  }
  DescriptorType() {
  }

  public String getCode() {
    return code;
  }
}
