package org.example.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
  @Nested
  class convertStringToHex {
    @Test
    void 正常確認() {
      String actual = StringUtils.convertStringToHex("Main.java");
      assertEquals("4d61696e2e6a617661", actual);
    }

    @Test
    void test() {
      System.out.println(Integer.toHexString(61));
    }
  }
}
