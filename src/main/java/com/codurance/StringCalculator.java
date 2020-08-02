package com.codurance;

import java.util.Arrays;

public class StringCalculator {

  public int add(String input) {
    StringBuilder regex = new StringBuilder("\\n,");
    StringBuilder result = new StringBuilder();

    if (input.startsWith("//")){
      regex.append(input, input.indexOf("//"), input.indexOf("\n"));
      result.append(input.substring(input.indexOf("\n")).trim());
    }else {
      result.append(input);
    }

    return Arrays.stream(result.toString().split("[" + regex + "]"))
        .map(String::strip)
        .filter(i -> !i.isBlank())
        .mapToInt(Integer::parseInt)
        .filter(n -> n <= 1000)
        .peek(n -> {
          if (n < 0) throw new IllegalArgumentException("Negatives not allowed");
        }).sum();

  }
}
