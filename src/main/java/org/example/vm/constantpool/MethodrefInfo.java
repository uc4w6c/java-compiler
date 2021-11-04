package org.example.vm.constantpool;

public class MethodrefInfo implements ConstantInfo {
  private int classIndex;
  private int nameAndTypeIndex;

  public MethodrefInfo(int classIndex, int nameAndTypeIndex) {
    this.classIndex = classIndex;
    this.nameAndTypeIndex = nameAndTypeIndex;
  }

  public int getClassIndex() {
    return classIndex;
  }

  public int getNameAndTypeIndex() {
    return nameAndTypeIndex;
  }

  @Override
  public ConstantType getTag() {
    return ConstantType.METHOD;
  }
}
