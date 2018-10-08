package com.edu.worksheet_1.exercise_3;

import static java.lang.String.format;
import static java.lang.System.out;

import java.util.LinkedList;

/**
 * Created by Pietro Cascio on 08/10/2018
 */
public class AdvancedFilterList<E> extends LinkedList<E> {

  private static final String ELEMENT_HAS_NOT_BEEN_ACCEPTED = "Element has not been accepted!";
  public static final String ERROR_IN_ADDING_THE_ELEMENT = "Error in adding the element! Error: %s";
  private AdvancedListFilter<E> advancedListFilter;

  public AdvancedFilterList(AdvancedListFilter<E> advancedListFilter) {
    this.advancedListFilter = advancedListFilter;
  }

  @Override
  public void addFirst(E element) {
    if (filter(element) != null) {
      super.addFirst(element);
    } else {
      throw new IllegalArgumentException(ELEMENT_HAS_NOT_BEEN_ACCEPTED);
    }
  }

  @Override
  public void addLast(E element) {
    if (filter(element) != null) {
      super.addLast(element);
    } else {
      throw new IllegalArgumentException(ELEMENT_HAS_NOT_BEEN_ACCEPTED);
    }
  }

  @Override
  public boolean add(E e) {
    if (filter(e) != null) {
      return super.add(e);
    } else {
      throw new IllegalArgumentException(ELEMENT_HAS_NOT_BEEN_ACCEPTED);
    }
  }

  private E filter(E e) {
    return this.advancedListFilter.filter(this, e);
  }

  @Override
  public void add(int index, E element) {
    if (filter(element) != null) {
      super.add(index, element);
    } else {
      throw new IllegalArgumentException(ELEMENT_HAS_NOT_BEEN_ACCEPTED);
    }
  }

  @Override
  public boolean offer(E e) {
    try {
      super.addLast(e);
    } catch (IllegalStateException e1) {
      System.out.println(format(ERROR_IN_ADDING_THE_ELEMENT, e1.getMessage()));
    }
    return true;
  }

  @Override
  public boolean offerFirst(E e) {
    try {
      addFirst(e);
    } catch (IllegalStateException e1) {
      out.println(format(ERROR_IN_ADDING_THE_ELEMENT, e1.getMessage()));
    }
    return true;
  }

  @Override
  public boolean offerLast(E e) {
    try {
      super.offer(e);
      return true;
    } catch (IllegalStateException e1) {
      throw new IllegalArgumentException(format(ERROR_IN_ADDING_THE_ELEMENT, e1.getMessage()));
    }
  }

  @Override
  public void push(E e) {
    try {
      addFirst(e);
    } catch (IllegalStateException e1) {
      throw new IllegalArgumentException(format(ERROR_IN_ADDING_THE_ELEMENT, e1.getMessage()));
    }
  }
}
