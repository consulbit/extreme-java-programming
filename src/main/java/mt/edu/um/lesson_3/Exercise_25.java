package mt.edu.um.lesson_3;

import static java.lang.System.out;
import static java.util.Comparator.comparingInt;

import java.util.Optional;
import java.util.stream.Stream;

public class Exercise_25 {

  public static final String AGE_IN_INCORRECT_FORMAT = "Age in incorrect format";

  public static void main(String[] args) {
    StudentData[] students = StudentDataUtil.generate();
    Stream<StudentData> studentsStream;

    // Find and print the youngest student
    studentsStream = Stream.of(students);
    StudentData youngestStudent =
        studentsStream
            .min(comparingInt(StudentData::getAge))
            .orElseThrow(() -> new IllegalArgumentException(AGE_IN_INCORRECT_FORMAT));
    out.printf("Youngest Student: %s%n", youngestStudent);

    // Find and print the oldest student in the array
    studentsStream = Stream.of(students);
    StudentData oldestStudent =
        studentsStream
            .max(comparingInt(StudentData::getAge))
            .orElseThrow(() -> new IllegalArgumentException(AGE_IN_INCORRECT_FORMAT));
    out.printf("Oldest Student: %s%n", oldestStudent);

    // The first student older than 21
    studentsStream = Stream.of(students);
    Optional<StudentData> firstStudentOlderThan21 =
        studentsStream
            .filter(student -> student.getAge() > 21)
            .sorted(comparingInt(StudentData::getAge))
            .findFirst();
    out.printf("Oldest Student: %s%n", firstStudentOlderThan21);

    // Any student is younger than 18 years old
    studentsStream = Stream.of(students);
    boolean isThereAnyStudentYoungerThan18 =
        studentsStream.anyMatch(student -> student.getAge() < 18);
    out.printf("Is there any student younger than 18? %s%n", isThereAnyStudentYoungerThan18);

    // All students are older than 15 years old.
    studentsStream = Stream.of(students);
    boolean allStudentsAreOlderThan15 = studentsStream.allMatch(student -> student.getAge() > 15);
    out.printf("Are all students older than 15 years old? %s%n", allStudentsAreOlderThan15);

    // No student is older than 35
    studentsStream = Stream.of(students);
    boolean noneStudentsAreOlderThan35 = studentsStream.noneMatch(student -> student.getAge() > 35);
    out.printf("No student is older than 35? %s%n", noneStudentsAreOlderThan35);
  }
}
