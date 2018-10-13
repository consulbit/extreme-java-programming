package mt.edu.um.lesson_2;

import java.util.List;

/** Created by Pietro Cascio on 12/10/2018 */
public class StudentData implements Student {
  private final long id;
  private final String name;
  private final String surname;
  private final Gender gender;
  private List<String> emails;

  public StudentData(long id, String name, String surname, Gender gender) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.gender = gender;
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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("StudentData{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", surname='").append(surname).append('\'');
    sb.append(", gender=").append(gender);
    sb.append(", nationality=").append(this.getNationality());
    sb.append(", emails=").append(this.getEmails());
    sb.append('}');
    return sb.toString();
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
}
