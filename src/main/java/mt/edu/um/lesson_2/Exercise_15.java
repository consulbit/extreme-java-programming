package mt.edu.um.lesson_2;

import static java.lang.System.out;

import java.util.stream.Stream;

/**
 * <h1>Exercise</h1>
 * <p>
 *   <ul>
 *     <li>
 *       Write an infinite stream which uses a <strong>generator</strong> function to provide all
 *       the multiples of 3, starting from 3.<br>
 *         <i>Hint</i>: You have to use <strong>Stream.iterate()</strong>
 *     </li>
 *     <li>Limit it to 10 elements</li>
 *     <li>For each element in the (finite) stream print it on screen, followed by a space</li>
 *   </ul>
 * </p>
 * Created by Pietro Cascio on 13/10/2018
 */
public class Exercise_15 {

  public static void main(String[] args) {
    Stream<Integer> multipleOfThree = Stream.iterate(3, seed -> seed + 3);

    multipleOfThree
        .limit(10)
        .forEach(num -> out.print(num + " "));
  }
}
