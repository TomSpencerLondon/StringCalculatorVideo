package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//Add("") // 0
//    Add("4") // 4
//    Add("1,2") // 3
//Add("1,2,3,4,5,6,7,8,9") // 45
//    Add("1\n2,3") // 6
//    Add("//;\n1;2") // 3
//    Add("1,-2,-3") // error: negatives not allowed: -2 -3
//    Add("1001, 2") // 2
//    Add("//[***]\n1***2***3") // 6
//    Add("//[*][%]\n1*2%3") // 6
//    Add("//[foo][bar]\n1foo2bar3") // 6
public class StringCalculatorShould {

  private StringCalculator stringCalculator;

  @BeforeEach
  void setUp() {
    stringCalculator = new StringCalculator();
  }

  @ParameterizedTest
  @CsvSource(value = {
      "''; 0",
      "0, 0; 0",
      "1, 0; 1"
  }, delimiter = ';')
  void returns_correct_output_with_input(String input, int output) {
    assertEquals(output, stringCalculator.add(input));
  }
}
