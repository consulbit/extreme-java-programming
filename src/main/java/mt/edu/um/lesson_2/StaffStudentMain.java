package mt.edu.um.lesson_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public class StaffStudentMain {

  private static List<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    students.add(new StaffStudent(1L, "User 1", "Surname 1", "A12345"));
    students.add(new StaffStudent(2L, "User 2", "Surname 2", "B12345"));
    students.add(new StaffStudent(3L, "User 3", "Surname 3", "C12345"));

    students.forEach(System.out::println);
  }
}
