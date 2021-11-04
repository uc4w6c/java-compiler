package org.example.vm.constantpool;

public enum ConstantType {
  CLASS("7"),
  FIELD("9"),
  METHOD("10"),
  INTERFACE("11"),
  STRING("8"),
  INTEGER("3"),
  FLOAT("4"),
  LONG("5"),
  DOUBLE("6"),
  NAME_AND_TYPE("12"),
  UTF8("1"),
  METHOD_HANDLE("15"),
  METHOD_TYPE("16"),
  INVOKE_DYNAMIC("18");

  String value;

  ConstantType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
