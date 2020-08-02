package com.codurance;

import java.util.Arrays;

public class StringCalculator {

  public int add(String input) {
    if (input.length() == 0){
      return 0;
    }

    return Arrays.stream(input.split("[,\n]"))
        .map(String::strip)
        .mapToInt(Integer::parseInt)
        .sum();

  }
}
