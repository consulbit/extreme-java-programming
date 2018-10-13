package mt.edu.um.lesson_2;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public interface Student {

  String getName();

  String getSurname();

  Long getId();

  default String getNationality() {
    return "Maltese";
  }
}
