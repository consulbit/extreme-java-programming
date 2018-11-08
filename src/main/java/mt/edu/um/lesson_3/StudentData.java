package mt.edu.um.lesson_3;

import java.util.List;
import java.util.Optional;
import mt.edu.um.lesson_2.Gender;
import mt.edu.um.lesson_2.Student;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public class StudentData implements Student {

  private long id;
  private String name;
  private String surname;
  private int age;
  private Gender gender;
  private List<String> emails;
  private String nationalId;
  private StudentData studentBuddy;

  public StudentData(long id, String name, String surname, int age, Gender gender,
      String nationalId) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.gender = gender;
    this.nationalId = nationalId;
  }

  public Optional<StudentData> getStudyBuddy() {
    return Optional.ofNullable(this.studentBuddy);
  }

  public void setStudentBuddy(StudentData studentBuddy) {
    this.studentBuddy = studentBuddy;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("StudentData{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", surname='").append(surname).append('\'');
    sb.append(", age='").append(age).append('\'');
    sb.append(", gender=").append(gender);
    sb.append(", emails=").append(emails);
    sb.append(", nationalId='").append(nationalId).append('\'');
//    sb.append(", buddyName='").append(studentBuddy.name).append('\'');
    sb.append('}');
    return sb.toString();
  }

  public Optional<String> getNationalId() {
    return Optional.ofNullable(nationalId);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getSurname() {
    return this.surname;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Gender getGender() {
    return this.gender;
  }

  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  public int getAge() {
    return age;
  }
}
