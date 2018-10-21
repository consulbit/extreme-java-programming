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
 * <p>
 *   Increase the limit to 15 (and check you get 15 unique random numbers)
 *   <ol>
 *     <li>What happens if you put <strong>limit()</strong> before <strong>distinct()</strong>?</li>
 *     <li>What happens if you put <strong>sorted()</strong> before <strong>limit()</strong>?</li>
 *     <li>What happens if you increase the limit to 43?</li>
 *     <li>What happens if you increase the limit to 43 and comment out <strong>sorted()</strong>?</li>
 *     <li>Think...How would you have done this using Java 7?</li>
 *   </ol>
 * </p>
 *
 * Created by Pietro Cascio on 13/10/2018
 */
public class Exercise_31 {

  public static void main(String[] args) {
    Stream.generate(() -> new Random().nextInt(42) + 1)
        .distinct()
        .limit(15)
        .sorted()
        .forEach(System.out::println);

//    Stream.generate(() -> new Random().nextInt(42) + 1)
//        .distinct()
//        .limit(43)
////        .sorted()
//        .forEach(System.out::println);
    // 1. What happens if you put limit() before distinct()?
    // From repeated tests, no duplicates have being shown BUT i believe that duplicates can be generated.

    // 2. What happens if you put sorted() before limit()?
    // This will generate an infinite loop

    // 3. What happens if you increase the limit to 43?
    // This will generate an infinite loop

    // 4. What happens if you increase the limit to 43 and comment out sorted()?
    // It prints 42 unique numbers but the program doesn't stop

    // 5. Think… How would you have done this using Java 7?
  }
}
