package mt.edu.um.lesson_2;

/**
 * Created by Pietro Cascio on 12/10/2018
 */
public interface Staff {

  String getName();

  String getSurname();

  Long getId();

  String getNiNumber();

  default String getNationality() {
    return "Maltese";
  }
}
