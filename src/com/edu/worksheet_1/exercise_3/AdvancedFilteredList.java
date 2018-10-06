package com.edu.worksheet_1.exercise_3;

import java.util.LinkedList;

/**
 * Created by Pietro Cascio on 06/10/2018
 */
public class AdvancedFilteredList<E> extends LinkedList<E> {

  private final AdvancedListFilter filterFunction;

  public AdvancedFilteredList(AdvancedListFilter filterFunction) {
    this.filterFunction = filterFunction;
  }
}
