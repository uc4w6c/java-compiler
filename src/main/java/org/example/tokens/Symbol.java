package org.example.tokens;

/**
 * シンボル
 * <p>
 *   com.sun.tools.javac.parser.Tokens.TokenKindからほぼ持ってきた
 */
public enum Symbol {
  ARROW("->"),
  COLCOL("::"),
  LPAREN("("),
  RPAREN(")"),
  LBRACE("{"),
  RBRACE("}"),
  LBRACKET("["),
  RBRACKET("]"),
  SEMI(";"),
  COMMA(","),
  DOT("."),
  ELLIPSIS("..."),
  EQ("="),
  GT(">"),
  LT("<"),
  BANG("!"),
  TILDE("~"),
  QUES("?"),
  COLON(":"),
  EQEQ("=="),
  LTEQ("<="),
  GTEQ(">="),
  BANGEQ("!="),
  AMPAMP("&&"),
  BARBAR("||"),
  PLUSPLUS("++"),
  SUBSUB("--"),
  PLUS("+"),
  SUB("-"),
  STAR("*"),
  SLASH("/"),
  AMP("&"),
  BAR("|"),
  CARET("^"),
  PERCENT("%"),
  LTLT("<<"),
  GTGT(">>"),
  GTGTGT(">>>"),
  PLUSEQ("+="),
  SUBEQ("-="),
  STAREQ("*="),
  SLASHEQ("/="),
  AMPEQ("&="),
  BAREQ("|="),
  CARETEQ("^="),
  PERCENTEQ("%="),
  LTLTEQ("<<="),
  GTGTEQ(">>="),
  GTGTGTEQ(">>>="),
  MONKEYS_AT("@");

  String code;

  Symbol(String code) {
    this.code = code;
  }

  public static boolean isSymbol(String code) {
    for (Symbol symbol : Symbol.values()) {
      if (symbol.code.equals(code)) {
        return true;
      }
    }
    return false;
  }
}
