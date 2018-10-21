package mt.edu.um.lesson_2;

import java.util.stream.Stream;

/**
 * <h1>Exercise Page 22</h1>
 * <p>
 * <ul>
 * <li>
 * The Fibonacci sequence is seeded by 2 numbers, 0 and 1. The formula to generate the sequence is
 * <strong><math>x<sub>n</sub> = x<sub>n-1</sub> + x<sub>n-2</sub></strong></math>.
 * </li>
 * <li>
 * The resultant sequence looks like this: 1,1,2,3,4,8,13,21,34,55
 * <ol>
 * <li>
 * Write a class <strong>FibPair</strong> which has two (final) member integers,
 * <strong>prev</strong> and <strong>next</strong>, initialised through constructor arguments.
 * </li>
 * <li>
 * Add a method <strong>generate()</strong> which returns a new instance of <strong>FibPair</strong>
 * which is the successor of the current pair (i.e. prev is assigned to the current next, and next
 * is assigned to the current prev + current next).
 * </li>
 * <li>
 * In your <strong>main()</strong></> method use a stream of <strong>FibPair</strong> objects to
 * generate the Fibonacci sequence, and map it to integers to get the final sequence. Print the
 * first 10 numbers of the sequence separated by space.
 * </li>
 * </ol>
 * </li>
 * </ul>
 * </p>
 * Created by Pietro Cascio on 13/10/2018
 */
public class Exercise_22 {

  public static void main(String[] args) {
    FibPair generator = new FibPair(0, 1);
    Stream<FibPair> fibonacciSequence = Stream.iterate(new FibPair(0, 1), FibPair::generate);

    fibonacciSequence.limit(10)
        .map(FibPair::getNext)
        .forEach(fibPair -> System.out.print(fibPair + " "));
  }
}

class FibPair {

  private final int prev;
  private final int next;

  FibPair(int prev, int next) {
    this.prev = prev;
    this.next = next;
  }

  public int getNext() {
    return next;
  }

  FibPair generate() {
    return new FibPair(next, prev + next);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("FibPair{");
    sb.append("prev=").append(prev);
    sb.append(", next=").append(next);
    sb.append('}');
    return sb.toString();
  }
}
