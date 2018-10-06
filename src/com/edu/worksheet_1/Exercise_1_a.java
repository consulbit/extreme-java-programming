package com.edu.worksheet_1;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a method which fills an Integer array of a pre-defined size with <strong>random positive
 * integers</strong>. Use <strong>Arrays.setAll()</strong> to invoke your random generation code.
 * <strong>Do not iterate the array itself.</strong>
 *
 * <p>Created by Pietro Cascio on 05/10/2018
 */
public class Exercise_1_a {
  public static void main(String[] args) {
    Integer[] integers = new Integer[100];
    Arrays.setAll(integers, Exercise_1_a::generateRandomNumber);

    Arrays.sort(
        integers,
        (i1, i2) -> {
          String value1Str = String.valueOf(i1);
          String value2Str = String.valueOf(i2);
          if ((value2Str.length() - value1Str.length()) == 0) {
            return i2 - i1;
          }
          return value1Str.length() - value2Str.length();
        });

    for (Integer integer : integers) {
      System.out.println(integer);
    }
  }

  private static int generateRandomNumber(int value) {
    return new Random().nextInt(1000);
  }
}
