package mt.edu.um.lesson_3;

import mt.edu.um.lesson_2.Gender;

/**
 * Created by Pietro Cascio on 24/10/2018
 */
public class StudentDataUtil {

  public static StudentData[] generate() {
    return new StudentData[]{
        new StudentData(1, "Name 1", "Surname 1", Gender.MALE, "A123"),
        new StudentData(2, "Name 2", "Surname 2", Gender.FEMALE, null),
        new StudentData(3, "Name 3", "Surname 3", Gender.FEMALE, "B123"),
        new StudentData(4, "Name 4", "Surname 4", Gender.MALE, null),
        new StudentData(5, "Name 5", "Surname 5", Gender.FEMALE, "C123")
    };
  }
}
