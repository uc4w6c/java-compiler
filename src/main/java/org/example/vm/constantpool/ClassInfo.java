package org.example.vm.constantpool;

// ConstantType.CLASS
public class ClassInfo implements ConstantInfo {
  private int index;

  public ClassInfo(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }

  @Override
  public ConstantType getTag() {
    return ConstantType.CLASS;
  }
}
