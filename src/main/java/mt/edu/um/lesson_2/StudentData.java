package mt.edu.um.lesson_2;

/** Created by Pietro Cascio on 12/10/2018 */
public class StudentData implements Student {
  private final long id;
  private final String name;
  private final String surname;

  public StudentData(long id, String name, String surname) {
    this.id = id;
    this.name = name;
    this.surname = surname;
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
  public String toString() {
    return "StudentData{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", nationality ='" + this.getNationality() + '\'' +
        '}';
  }

  @Override
  public Long getId() {
    return this.id;
  }
}
