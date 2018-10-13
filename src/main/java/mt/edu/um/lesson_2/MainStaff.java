package mt.edu.um.lesson_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public class MainStaff {

  static List<Staff> staffList = new ArrayList<>();

  public static void main(String[] args) {
    staffList.add(new StaffData(1L, "12345", "User 1", "Surname 1"));
    staffList.add(new StaffData(2L, "A1234", "User 2", "Surname 2"));
    staffList.add(new StaffData(3L, "B1234", "User 2", "Surname 2"));

    staffList.forEach(System.out::println);
  }
}
