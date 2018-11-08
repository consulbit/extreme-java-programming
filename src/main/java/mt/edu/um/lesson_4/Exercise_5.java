package mt.edu.um.lesson_4;

import java.util.stream.Stream;

public class Exercise_5 {

  public static void main(String[] args) {
    double average = Stream.of(1, 5, 10, 25, 50)
        .collect(Averager::new, Averager::add, Averager::combine)
        .average();
    System.out.printf("Average: %s", average);
  }
}
