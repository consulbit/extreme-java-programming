package mt.edu.um.lesson_3;

import mt.edu.um.lesson_2.Gender;

/**
 * Created by Pietro Cascio on 24/10/2018
 */
public class StudentDataUtil {

  public static StudentData[] generate() {
    return new StudentData[]{
        new StudentData(1, "Name 1", "Surname 1", 25, Gender.MALE, "A123"),
        new StudentData(2, "Name 2", "Surname 2", 43, Gender.MALE, null),
        new StudentData(3, "Name 3", "Surname 3", 30, Gender.FEMALE, "B123"),
        new StudentData(4, "Name 4", "Surname 4", 35, Gender.MALE, null),
        new StudentData(5, "Name 5", "Surname 5", 27, Gender.FEMALE, "C123"),
        new StudentData(6, "Name 6", "Surname 6", 16, Gender.FEMALE, "Z123"),
        new StudentData(7, "Name 7", "Surname 7", 12, Gender.FEMALE, "X123")
    };
  }
}
