package mt.edu.um.worksheet_1.exercise_2;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Pietro Cascio on 06/10/2018
 */
public class FilteredList<E> extends LinkedList<E> {

  public static final String ELEMENT_HAS_NOT_BEEN_ACCEPTED = "Element %s has not been accepted";
  private Predicate<E> predicate;

  public FilteredList(Predicate<E> predicate) {
    this.predicate = predicate;
  }

  public void setPredicate(Predicate<E> predicate) {
    this.predicate = predicate;
  }

  @Override
  public boolean offer(E e) {
    try {
      super.addLast(e);
    } catch (IllegalStateException e1) {
      System.out.println(format("Error in adding the element! Error: %s", e1.getMessage()));
    }
    return true;
  }

  @Override
  public boolean offerLast(E e) {
    try {
      super.offer(e);
      return true;
    } catch (IllegalStateException e1) {
      throw new IllegalArgumentException(
          format("Error in adding the element! Error: %s", e1.getMessage()));
    }
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    boolean allElementsPassedCheck = true;
    for (E e1 : new ArrayList<>(c)) {
      if (!checkElementValidity(e1)) {
        allElementsPassedCheck = false;
        break;
      }
    }
    try {
      if (allElementsPassedCheck) {
        return super.addAll(c);
      } else {
        throw new IllegalArgumentException("Not all elements passed the check");
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(
          format("Error in adding the collection! Error: %s", e.getMessage()));
    }
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    try {
      List<? extends E> list = new ArrayList<>(c);
      if (checkElementValidity(list.get(index))) {
        return super.addAll(index, c);
      } else {
        throw new IllegalArgumentException("Not all elements passed the check");
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(
          format("Error in adding the collection. Error: %s", e.getMessage()));
    }
  }

  private boolean checkElementValidity(E e) {
    return this.predicate.test(e);
  }

  @Override
  public boolean offerFirst(E e) {
    try {
      addFirst(e);
    } catch (IllegalStateException e1) {
      System.out.println(format("Error in adding the element! Error: %s", e1.getMessage()));
    }
    return true;
  }

  @Override
  public void push(E e) {
    try {
      super.push(e);
    } catch (IllegalStateException e1) {
      throw new IllegalArgumentException(
          format("Error in adding the element! Error: %s", e1.getMessage()));
    }
  }

  @Override
  public void addFirst(E e) {
    if (checkElementValidity(e)) {
      super.addFirst(e);
    } else {
      throw new IllegalArgumentException(format(ELEMENT_HAS_NOT_BEEN_ACCEPTED, e));
    }
  }

  @Override
  public void addLast(E e) {
    if (checkElementValidity(e)) {
      super.addLast(e);
    } else {
      throw new IllegalArgumentException(format(ELEMENT_HAS_NOT_BEEN_ACCEPTED, e));
    }
  }

  @Override
  public boolean add(E e) {
    if (checkElementValidity(e)) {
      return super.add(e);
    } else {
      throw new IllegalArgumentException(format(ELEMENT_HAS_NOT_BEEN_ACCEPTED, e));
    }
  }

  @Override
  public void add(int index, E element) {
    if (checkElementValidity(element)) {
      super.add(index, element);
    } else {
      throw new IllegalArgumentException(format(ELEMENT_HAS_NOT_BEEN_ACCEPTED, element));
    }
  }
}
