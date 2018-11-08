package mt.edu.um.lesson_2;

/**
 * Created by Pietro Cascio on 13/10/2018
 */
public enum Gender {
  MALE("Male"), FEMALE("Female");

  private final String gender;

  Gender(String gender) {
    this.gender = gender;
  }

  public String getGenderPrintableFormat() {
    return gender;
  }
}
