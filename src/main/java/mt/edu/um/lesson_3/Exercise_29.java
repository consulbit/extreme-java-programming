package mt.edu.um.lesson_3;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Create a simple stream of 5 integers using Stream.of() and use the reduce() method which returns
 * Optional<Integer> to return the product of all the values (that is all numbers multiplied
 * together).
 */
public class Exercise_29 {

  public static void main(String[] args) {
    Stream<Integer> integers = Stream.of(31, 17, 6, 16, 17);
    Optional<Integer> productAmongAllValues = integers.reduce((acc, value) -> acc * value);
    System.out.println("Total product: " + productAmongAllValues.orElse(1));

    Stream<Integer> integers2 = Stream.of(31, 17, 6, 16, 17);
    Integer productAmongAllValues2 = integers2.reduce(1, (acc, value) -> acc * value);
    System.out.println("Total product: " + productAmongAllValues2);
  }
}
