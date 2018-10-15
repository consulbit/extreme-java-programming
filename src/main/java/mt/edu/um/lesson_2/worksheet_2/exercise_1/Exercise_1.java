package mt.edu.um.lesson_2.worksheet_2.exercise_1;

import java.util.stream.Stream;

/**
 * <h1>LAS3006 – Worksheet 2 – Introduction to Streams</h1>
 *
 * <p>
 *
 * <ol>
 * <li><strong>Create an infinite Stream<Integer> for each of the following mathematical
 * sequence:</strong><br> The triangular number series provides the sequence of numbers that can
 * form an equilateral triangle. The n<sup>th</sup> triangle number is the number of balls or dots
 * in a triangle, with n dots on one side.<br> The formula for this sequence is:<br>
 * <math> <box>T<sub>n</sub> = 1 + 2 + 3 + ... + n = n(n + 1)<over>/2</box> </math>
 * </ol>
 *
 * Created by Pietro Cascio on 15/10/2018
 */
public class Exercise_1 {

  public static void main(String[] args) {
    EquilateralTriangleGenerator seed = new EquilateralTriangleGenerator(0);

    // TODO: Verify why I need to skip the first value
    Stream<Integer> equilateralTriangleStream =
        Stream.iterate(seed, EquilateralTriangleGenerator::generateNext)
            .skip(1)
            .map(EquilateralTriangleGenerator::getComputedN)
            .limit(10);
    equilateralTriangleStream.forEach(ele -> System.out.print(ele + ", "));
  }
}

class EquilateralTriangleGenerator {

  private int n;
  private int computedN;

  EquilateralTriangleGenerator(int n) {
    this.n = n;
  }

  public EquilateralTriangleGenerator generateNext() {
    EquilateralTriangleGenerator equilateralTriangleGenerator =
        new EquilateralTriangleGenerator(n + 1);
    equilateralTriangleGenerator.setComputedN((n * (n + 1)) / 2);

    return equilateralTriangleGenerator;
  }

  public int getN() {
    return n;
  }

  public int getComputedN() {
    return computedN;
  }

  public void setComputedN(int computedN) {
    this.computedN = computedN;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("EquilateralTriangleGenerator{");
    sb.append("n=").append(n);
    sb.append(", computedN=").append(computedN);
    sb.append('}');
    return sb.toString();
  }
}
