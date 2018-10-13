package mt.edu.um.lesson_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public class Main {

  static List<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    students.add(new StudentData(1, "Piero", "Cascio", Gender.MALE));
    students.add(new InternationStudentData(2, "User 1", "Surname 1", "Italian", Gender.FEMALE));
    students.add(new InternationStudentData(2, "User 2", "Surname 2", "French", Gender.FEMALE));

    students.forEach(System.out::println);
  }
}
