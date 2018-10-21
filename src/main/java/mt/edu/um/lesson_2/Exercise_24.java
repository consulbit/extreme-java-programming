package mt.edu.um.lesson_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * <h1>Exercise Page 24</h1>
 *
 * <p>
 * Each student can provide a list of email addresses, on which he may be notified about the courses
 * he is attending.
 * <ol>
 * <li>
 * Using the previous students exercise, add alist of email addresses to the
 * <strong>StudentData</strong> class. (You can use an array or a list of <strong>String</strong>).
 * <ul>
 * <li>Populate the students' array with a few email addresses for each student.</li>
 * </ul>
 * <li>
 * You need to notify <strong>all</strong> the students on <strong>all</strong> the email addresses
 * they provided. Create a stream of email addresses from all the students using
 * <strong>flatMap()</strong>, making no distinction between who provided the email address.
 * </li>
 * <li>Go through all the elements in the email addresses stream and print them.</li>
 * </li>
 * </ol>
 * </p>
 * Created by Pietro Cascio on 13/10/2018
 */
public class Exercise_24 {

  public static void main(String[] args) {
    List<StudentData> students = new ArrayList<>();
    initializeStudentArray(students);
    Stream<String> allEmailAddresses = students.stream()
        .flatMap(student -> student.getEmails().stream());
    allEmailAddresses.forEach(System.out::println);
  }

  private static void initializeStudentArray(List<StudentData> students) {
    for (int index = 0; index < 10; index++) {
      StudentData student = new StudentData(1, "name " + index, "surname " + index,
          generateRandomGender());
      List<String> student1EmailAddresses = Arrays
          .asList(String.format("student%s@test.com", index),
              String.format("student%s@edu.mt", index));
      student.setEmails(student1EmailAddresses);
      students.add(student);
    }
  }

  private static Gender generateRandomGender() {
    return Math.random() > 0.5 ? Gender.MALE : Gender.FEMALE;
  }
}
