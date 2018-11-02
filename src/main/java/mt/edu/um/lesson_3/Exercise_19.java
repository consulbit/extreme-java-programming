package mt.edu.um.lesson_3;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by Pietro Cascio on 21/10/2018
 */
public class Exercise_19 {

  public static void main(String[] args) {
    final Random randomizer = new Random();

    StudentData[] students = StudentDataUtil.generate();
    for (int index = 0; index < students.length; index++) {
      int randonStudentIndex;
      while (index == (randonStudentIndex = randomizer.nextInt(students.length))) {
        System.out.println("Skip buddy student as it's itself");
      }
      students[index].setStudentBuddy(students[randonStudentIndex]);
    }

    students[students.length - 1].setStudentBuddy(null);
    System.out.println("Assigned buddy students");
    Stream.of(students)
        .map(
            studentData ->
                studentData.getStudyBuddy().flatMap(StudentData::getNationalId).orElse("Foreign"))
        .forEach(System.out::println);
  }
}
