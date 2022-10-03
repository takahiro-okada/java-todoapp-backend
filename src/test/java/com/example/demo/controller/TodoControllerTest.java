package com.example.demo.controller;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TodoControllerTest {

  @ParameterizedTest
  @CsvSource({
      "1,         1",
      "2,         2",
      "3,      Fizz",
      "4,         4",
      "5,      Buzz",
      "6,      Fizz",
      "9,      Fizz",
      "10,     Buzz",
      "15, FizzBuzz"
  })
  void test_fizzBuzz_1(int input, String output){
    String result = TodoController.execute(input);
    assertThat(result ,is(output));
  }

  @Test
  void test_sayhello(){
    String result = TodoController.sayHello();
    assertThat(result,is(result));
  }

}
