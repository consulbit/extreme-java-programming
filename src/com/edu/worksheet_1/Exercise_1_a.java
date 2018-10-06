package com.edu.worksheet_1;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a method which fills an Integer array of a pre-defined size with
 * <strong>random positive integers</strong>. Use <strong>Arrays.setAll()</strong> to invoke
 * your random generation code. <strong>Do not iterate the array itself.</strong>
 *
 * Created by Pietro Cascio on 05/10/2018
 */
public class Exercise_1_a {
  public static void main(String[] args) {
    Integer[] integers = new Integer[100];
    Arrays.setAll(integers, integer -> integer = new Random().nextInt(100));

    for (Integer integer : integers) {
      System.out.println(integer);
    }
  }
}
