package mt.edu.um.lesson_4;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import mt.edu.um.lesson_3.StudentData;
import mt.edu.um.lesson_3.StudentDataUtil;

public class Exercise_13 {

  public static void main(String[] args) {
    StudentData[] students = StudentDataUtil.generate();

    Map<Long, StudentData> studentMap =
        Arrays.stream(students).collect(toMap(StudentData::getId, Function.identity()));
    studentMap.forEach(Exercise_13::printKeyValuePair);

    // Modify one of the Student IDs and reuse one of the other students. Test your program
    // and see what happens.
//    students[0].setId(students[1].getId());
//    studentMap = Arrays.stream(students).collect(toMap(StudentData::getId, Function.identity()));
//    studentMap.forEach(Exercise_13::printKeyValuePair);

    // Modify your function such that it returns a Map<String, List<StudentData>>,
    // such that in case of collision you merge both lists into one.
    students[0].setId(students[1].getId());
    studentMap =
        Arrays.stream(students)
            .collect(
                toMap(
                    StudentData::getId,
                    Function.identity(),
                    (existent, newValue) -> {
                      System.err.println("Collision found! Ignoring new value!");
                      return existent;
                    }));
    studentMap.forEach(Exercise_13::printKeyValuePair);
  }

  private static void printKeyValuePair(Long key, StudentData value) {
    System.out.printf("[%s]: %s%n", key, value);
  }
}
