package mt.edu.um.lesson_4;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mt.edu.um.lesson_2.Gender;
import mt.edu.um.lesson_3.StudentData;
import mt.edu.um.lesson_3.StudentDataUtil;

/**
 * <h1>Exercise Pag. 21</h1>
 *
 * <p>
 *
 * <ol>
 * <li>Group your StudentData array by gender.</li>
 * <li>
 * Use the appropriate summary statistics collector to calculate the total number of students, and
 * min / max / average student age of each gender by using it as a downstream collector.
 * </li>
 * <li>Print out this information in a user presentable format</li>
 * </ol>
 */
public class Exercise_21 {

  public static void main(String[] args) {
    StudentData[] students = StudentDataUtil.generate();

    Stream<StudentData> studentsStream = Arrays.stream(students);
    Map<Gender, IntSummaryStatistics> summary = studentsStream
        .collect(Collectors.groupingBy(StudentData::getGender,
            Collectors.summarizingInt(StudentData::getAge)));

    print(summary, Gender.MALE);
    print(summary, Gender.FEMALE);
  }

  private static void print(Map<Gender, IntSummaryStatistics> map, Gender gender) {
    IntSummaryStatistics maleSummary = map.get(gender);
    printSummaryInfo(maleSummary, gender);
  }

  private static void printSummaryInfo(IntSummaryStatistics maleSummary,
      Gender gender) {
    System.out.print("/************************************************/\n");
    System.out.printf("%s statistics%n", gender.getGenderPrintableFormat());
    System.out.printf("Total number: %s%n", maleSummary.getCount());
    System.out.printf("Total age: %s%n", maleSummary.getSum());
    System.out.printf("Minimum age: %s%n", maleSummary.getMin());
    System.out.printf("Maximum age: %s%n", maleSummary.getMax());
    System.out.printf("Average age: %s%n", maleSummary.getAverage());
  }
}
