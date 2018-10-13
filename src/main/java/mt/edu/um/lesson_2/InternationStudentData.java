package mt.edu.um.lesson_2;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public class InternationStudentData extends StudentData {

  private String nationality;

  public InternationStudentData(long id, String name, String surname, String nationality,
      Gender gender) {
    super(id, name, surname, gender);
    this.nationality = nationality;
  }

  @Override
  public String getNationality() {
    return this.nationality;
  }
}
