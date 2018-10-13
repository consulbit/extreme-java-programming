package mt.edu.um.lesson_2;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public class StaffStudent implements Student, Staff {

  private Long id;
  private String name;
  private String surname;
  private String niNumber;

  public StaffStudent(Long id, String name, String surname, String niNumber) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.niNumber = niNumber;
  }

  @Override
  public String getNiNumber() {
    return this.niNumber;
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
  public String getNationality() {
    return Staff.super.getNationality();
  }

  @Override
  public String toString() {
    return "StaffStudent{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", niNumber='" + niNumber + '\'' +
        ", nationality ='" + getNationality() + '\'' +
        '}';
  }
}
