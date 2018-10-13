package mt.edu.um.lesson_2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * <h1>Exercise page 20</h1>
 *
 * <p>
 *
 * <ul>
 * <li>Using your previous Students exercise, add a new <strong>enum</strong> called
 * <strong>Gender</strong> and add at least <strong>MALE</strong> and <strong>FEMALE</strong>
 * to it (feel free to add others).
 * <li>Modify your <strong>StudentData</strong> class by adding a new field geneder (of type
 * Gender) and initialise it trough the constructor, add a getter method and update the
 * <strong>toString()</strong> accordingly. Update your array.
 * <li>From your students array, create a new <strong>Stream</strong> of only
 * <strong>MALE</strong> students and another stream of <strong>non-MALE</strong> students.
 * (Hint: Use the methods <strong>Stream.of()</strong> and <strong>filter()</strong>)
 * <li>Consume both streams, by first printing out the MALE students and then the non-MALE ones.
 * </ul>
 *
 * Created by Pietro Cascio on 13/10/2018
 */
public class Exercise_20 {

  private static List<Student> students = new ArrayList<>();
  private static Predicate<Student> maleStudentPredicate =
      student -> Gender.MALE == student.getGender();
  private static Predicate<Student> nonMalePredicate = maleStudentPredicate.negate();

  public static void main(String[] args) {
    students.add(new StudentData(1, "Piero", "Cascio", Gender.MALE));
    students.add(new InternationStudentData(2, "User 1", "Surname 1", "Italian", Gender.FEMALE));
    students.add(new InternationStudentData(2, "User 2", "Surname 2", "French", Gender.FEMALE));

    // TODO: Question - Ask why I should've used the Stream.of() method
    Stream<Student> maleStudents = students.stream().filter(maleStudentPredicate);
    System.out.println("Male students");
    maleStudents.forEach(System.out::println);
    System.out.println("--------------------------------------");

    Stream<Student> nonMaleStudents = students.stream().filter(nonMalePredicate);
    System.out.println("Not male students");
    nonMaleStudents.forEach(System.out::println);
    System.out.println("--------------------------------------");
  }
}
