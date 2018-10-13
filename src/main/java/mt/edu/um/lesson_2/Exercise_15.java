package mt.edu.um.lesson_2;

import static java.lang.System.out;

import java.util.stream.Stream;

/**
 * Created by Pietro Cascio on 13/10/2018
 */
public class Exercise_15 {

  public static void main(String[] args) {
    Stream<Integer> multipleOfThree = Stream.iterate(1, seed -> seed + 1)
        .filter(num -> (num % 3) == 0);

    multipleOfThree
        .limit(10)
        .forEach(num -> out.print(num + " "));
  }
}
