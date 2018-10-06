package com.edu.worksheet_1.exercise_2;

import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by Pietro Cascio on 06/10/2018
 */
public class FilteredList<E> extends LinkedList<E> {

  private final Predicate<E> predicate;

  public FilteredList(Predicate<E> predicate) {
    this.predicate = predicate;
  }
}
