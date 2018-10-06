package com.edu.worksheet_1.exercise_2;

import static java.lang.String.format;

import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by Pietro Cascio on 06/10/2018
 */
public class FilteredList<E> extends LinkedList<E> {

  public static final String ELEMENT_HAS_NOT_BEEN_ACCEPTED = "Element %s has not been accepted";
  private final Predicate<E> predicate;

  public FilteredList(Predicate<E> predicate) {
    this.predicate = predicate;
  }

  @Override
  public boolean offer(E e) {
    try {
      addLast(e);
    } catch (IllegalStateException e1) {
      System.out.println(format("Error in adding the element!"));
    }
    return true;
  }

  @Override
  public boolean offerLast(E e) {
    try {
      offer(e);
    } catch (IllegalStateException e1) {
      System.out.println(format("Error in adding the element!"));
    }
  }

  @Override
  public boolean offerFirst(E e) {
    try {
      addFirst(e);
    } catch (IllegalStateException e1) {
      System.out.println(format("Error in adding the element!"));
    }
    return true;
  }

  @Override
  public void push(E e) {
    try {
      push(e);
    } catch (IllegalStateException e1) {
      System.out.println(format("Error in adding the element!"));
    }
  }

  @Override
  public void addFirst(E e) {
    if (predicate.test(e)) {
      super.addFirst(e);
    } else {
      throw new IllegalArgumentException(format(ELEMENT_HAS_NOT_BEEN_ACCEPTED, e));
    }
  }

  @Override
  public void addLast(E e) {
    if (predicate.test(e)) {
      super.addLast(e);
    } else {
      throw new IllegalArgumentException(format(ELEMENT_HAS_NOT_BEEN_ACCEPTED, e));
    }
  }

  @Override
  public boolean add(E e) {
    if (predicate.test(e)) {
      return super.add(e);
    } else {
      throw new IllegalArgumentException(format(ELEMENT_HAS_NOT_BEEN_ACCEPTED, e));
    }
  }

  @Override
  public void add(int index, E element) {
    if (predicate.test(element)) {
      super.add(index, element);
    } else {
      throw new IllegalArgumentException(format(ELEMENT_HAS_NOT_BEEN_ACCEPTED, element));
    }
  }
}