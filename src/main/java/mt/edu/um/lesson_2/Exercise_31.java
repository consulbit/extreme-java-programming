package mt.edu.um.lesson_2;

import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * <h1>Exercise Page 31</h1>
 *
 * <p>
 *
 * <ul>
 * <li>Write a small program which generates <strong>5 unique numbers</strong> from 1 to 42
 * (inclusive) using a <strong>stream</strong> with a <strong>generator</strong> and prints them out
 * <strong>sorted</strong>.<br>
 * <strong>Hint:</strong> Create a <strong>{@link java.util.Random}</strong> object and use
 * the <strong>{@link java.util.Random#nextInt(int)}</strong> method with an upper bound. Remember
 * that the number returned will be from 0 (inclusive) to the upper bound (exclusive).
 * <li>Use the stream's <strong>{@link java.util.stream.Stream#forEach(Consumer)}</strong> to
 * print each number on a separate line.
 * </ul>
 *
 * Created by Pietro Cascio on 13/10/2018
 */
public class Exercise_31 {

  public static void main(String[] args) {
    Stream.generate(() -> new Random().nextInt(42) + 1)
        .distinct()
        .limit(5)
        .forEach(System.out::println);
  }
}
