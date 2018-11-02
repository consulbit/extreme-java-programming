package mt.edu.um.lesson_3;

import java.util.Arrays;

/**
 * Created by Pietro Cascio on 21/10/2018
 */
public class Exercise_7 {

  private static StudentData[] students = StudentDataUtil.generate();

  public static void main(String[] args) {
    Arrays.stream(students)
        .forEach(student -> student.getNationalId().ifPresent(System.out::println));
  }
}
