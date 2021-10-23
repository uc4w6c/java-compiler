package org.example.tokens;

public enum KeyWord {
  PUBLIC("public"),
  CLASS("class"),
  STATIC("static"),
  INT("int"),
  CHAR("char"),
  BOOLEAN("boolean"),
  VOID("void"),
  TRUE("true"),
  FALSE("false"),
  NULL("null"),
  THIS("this"),
  IF("if"),
  ELSE("else"),
  WHILE("while"),
  FOR("for"),
  RETURN("return");

  String code;

  KeyWord(String code) {
    this.code = code;
  }

  public static boolean isKeyword(String code) {
    for (KeyWord keyword : KeyWord.values()) {
      if (code.equals(keyword.code)) {
        return true;
      }
    }
    return false;
  }
}
