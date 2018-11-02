package mt.edu.um.lesson_3;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;

public class Exercise_25 {

  public static void main(String[] args) {
    StudentData[] students = StudentDataUtil.generate();
    Stream<StudentData> studentsStream;

    // Find and print the youngest student
    studentsStream = Stream.of(students);
    StudentData youngestStudent =
        studentsStream
            .min(comparingInt(StudentData::getAge))
            .orElseThrow(() -> new IllegalArgumentException("Age in incorrect format"));
    System.out.println("Youngest Student: " + youngestStudent);

    // Find and print the oldest student in the array
    studentsStream = Stream.of(students);
    StudentData oldestStudent =
        studentsStream
            .max(comparingInt(StudentData::getAge))
            .orElseThrow(() -> new IllegalArgumentException("Age in incorrect format"));
    System.out.println("Oldest Student: " + oldestStudent);

    // The first student older than 21
    studentsStream = Stream.of(students);
    StudentData firstStudentOlderThan21 =
        studentsStream
            .filter(student -> student.getAge() > 21)
            .sorted(comparingInt(StudentData::getAge))
            .collect(toList())
            .get(0);
    System.out.println("Oldest Student: " + firstStudentOlderThan21);

    // Any student is younger than 18 years old
    studentsStream = Stream.of(students);
    boolean isThereAnyStudentYoungerThan18 =
        studentsStream.anyMatch(student -> student.getAge() < 18);
    System.out.println("Is there any student younger than 18? " + isThereAnyStudentYoungerThan18);

    // All students are older than 15 years old.
    studentsStream = Stream.of(students);
    boolean allStudentsAreOlderThan15 = studentsStream.allMatch(student -> student.getAge() > 15);
    System.out.println("Are all students older than 15 years old? " + allStudentsAreOlderThan15);

    // No student is older than 35
    studentsStream = Stream.of(students);
    boolean noneStudentsAreOlderThan35 = studentsStream.noneMatch(student -> student.getAge() > 35);
    System.out.println("No student is older than 35? " + noneStudentsAreOlderThan35);
  }
}
