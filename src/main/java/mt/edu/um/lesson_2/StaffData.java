package mt.edu.um.lesson_2;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public class StaffData implements Staff {

  private Long id;
  private String niNumber;
  private String name;
  private String surname;

  public StaffData(Long id, String niNumber, String name, String surname) {
    this.id = id;
    this.niNumber = niNumber;
    this.name = name;
    this.surname = surname;
  }

  @Override
  public String toString() {
    return "StaffData{" +
        "id=" + id +
        ", niNumber='" + niNumber + '\'' +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        '}';
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
  public String getNiNumber() {
    return this.niNumber;
  }
}
