package com.edu;

import static java.lang.System.out;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pietro Cascio on 05/10/2018
 */
public class UserDataMain {

  public static void main(String[] args) {
    List<StudentData> users = new ArrayList();

    users.add(new StudentData(1, "Piero", "Cascio"));
    users.add(new StudentData(2, "Piero", "Cascio"));
    users.add(new StudentData(3, "Alberto", "AnotherOne"));
    users.add(new StudentData(4, "Giuseppe", "Cascio"));
    users.add(new StudentData(5, "Piero1", "Cascio"));
    users.add(new StudentData(6, "Piero2", "Another"));
    users.add(new StudentData(7, "Piero3", "Cascio"));
    users.add(new StudentData(8, "Piero", "Cascio"));
    users.add(new StudentData(9, "Giuseppe", "Cascio"));
    users.add(new StudentData(10, "Piero", "Cascio"));

    sort(users, StudentData::compareTo);

    users.forEach(out::println);
  }

}
