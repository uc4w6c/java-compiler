package org.example.vm;

public class MethodDescriptor {
  private DescriptorType descriptorType;
  private String descriptorName;
  private boolean isVarargs;

  public MethodDescriptor(DescriptorType descriptorType, String descriptorName, boolean isVarargs) {
    this.descriptorType = descriptorType;
    this.descriptorName = descriptorName;
    this.isVarargs = isVarargs;
  }
}
