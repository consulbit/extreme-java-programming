package mt.edu.um.worksheet_1.exercise_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 1. Integer Array Manipulation using Lambda Expressions
 *
 * <ul>
 * <li>
 * a) Write a method which fills an Integer array of a pre-defined size with <strong>random positive
 * integers</strong>. Use <strong>Arrays.setAll()</strong> to invoke your random generation code.
 * <strong>Do not iterate the array itself.</strong>
 * </li>
 * <li>
 * b) If it is not already in a separate method, put the random generation code in a separate
 * function. Call it from <strong>Arrays.setAll()</strong> as a <strong>method reference.</strong>
 * </li>
 * <li>
 * c) Create a <strong>Comparator&lt;Integer&gt;</strong>, that puts the <strong>shortest</strong>
 * integer first, in terms of number of digits (you can just convert the integer to a string first.
 * If 2 integers have the same number of digits, sort them in <strong>descending order</strong>. Use
 * a <strong>lambda expression</strong> to create it inline.
 * </li>
 * </ul>
 *
 * <p>Created by Pietro Cascio on 05/10/2018
 */
public class Exercise1 {

  private static Comparator<Integer> compareByDigitsLength = (i1, i2) -> {
    String value1Str = String.valueOf(i1);
    String value2Str = String.valueOf(i2);
    if (value2Str.length() - value1Str.length() == 0) {
      return i2.compareTo(i1);
    }
    return value1Str.length() - value2Str.length();
  };

  public static void main(String[] args) {
    Integer[] integers = new Integer[100];
    Arrays.setAll(integers, Exercise1::generateRandomNumber);

    Arrays.sort(integers, compareByDigitsLength);

    for (Integer integer : integers) {
      System.out.println(integer);
    }
  }

  private static int generateRandomNumber(int value) {
    return new Random().nextInt(10000);
  }
}
