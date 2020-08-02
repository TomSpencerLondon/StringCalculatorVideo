package com.codurance;

public class StringCalculator {

  public int add(String input) {
    if (input.length() == 0){
      return 0;
    }
    return Integer.parseInt(input.split(",")[0].trim())
        + Integer.parseInt(input.split(",")[1].trim());
  }
}
