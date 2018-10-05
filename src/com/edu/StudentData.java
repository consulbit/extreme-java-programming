package com.edu;

import java.util.Objects;

/** Created by Pietro Cascio on 05/10/2018 */
public class StudentData {

  private final int id;
  private final String name;
  private final String surname;

  public StudentData(int id, String name, String surname) {
    this.id = id;
    this.name = name;
    this.surname = surname;
  }

  public static int compareTo(StudentData o1, StudentData o2) {
    if (o1.getSurname().equals(o2.getSurname())) {
      if (o1.getName().equals(o2.getName())) {
        return Integer.compare(o1.getId(), o2.getId());
      } else {
        return o1.getName().compareTo(o2.getName());
      }
    } else {
      return o1.getSurname().compareTo(o2.getSurname());
    }
  }

  public String getSurname() {
    return surname;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentData studentData = (StudentData) o;
    return id == studentData.id
        && Objects.equals(name, studentData.name)
        && Objects.equals(surname, studentData.surname);
  }

  @Override
  public String toString() {
    return "StudentData{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", surname='"
        + surname
        + '\''
        + '}';
  }
}
