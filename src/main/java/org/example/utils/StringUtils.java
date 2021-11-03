package org.example.utils;

public class StringUtils {
  public static String convertStringToHex(String str) {
    StringBuilder stringBuilder = new StringBuilder();

    char[] charArray = str.toCharArray();

    for (char c : charArray) {
      String charToHex = Integer.toHexString(c);
      stringBuilder.append(charToHex);
    }
    return stringBuilder.toString();
  }
}
