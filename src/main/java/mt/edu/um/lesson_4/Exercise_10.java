package mt.edu.um.lesson_4;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mt.edu.um.lesson_3.StudentData;
import mt.edu.um.lesson_3.StudentDataUtil;

public class Exercise_10 {

  public static void main(String[] args) {
    StudentData[] students = StudentDataUtil.generate();

    Arrays.stream(students).filter(student -> student.getAge() > 15)
        .collect(Collectors.toList())
        .forEach(out::println);

    List<StudentData> studentList = Arrays.stream(students)
        .filter(student -> student.getAge() > 15)
        .collect(Collectors.toList());

    IntSummaryStatistics summary = studentList.stream()
        .collect(Collectors.summarizingInt(StudentData::getAge));
    System.out.println(summary);
  }
}
