package mt.edu.um.lesson_1.worksheet_1.exercise_3;

import static java.lang.System.err;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pietro Cascio on 06/10/2018
 */
public class AdvancedFilteredList<E> extends LinkedList<E> {

  private final AdvancedListFilter<E> advancedListFilter;

  public AdvancedFilteredList(AdvancedListFilter<E> filterFunction) {
    this.advancedListFilter = filterFunction;
  }

  @Override
  public void addFirst(E element) {
    super.addFirst(filter(this, element));
  }

  @Override
  public void addLast(E element) {
    super.addLast(filter(this, element));
  }

  @Override
  public boolean add(E element) {
    return super.add(filter(this, element));
  }

  @Override
  public void add(int index, E element) {
    super.add(index, filter(this, element));
  }

  @Override
  public boolean offer(E e) {
    super.addLast(e);
    return true;
  }

  @Override
  public boolean offerFirst(E e) {
    this.addFirst(e);
    return true;
  }

  @Override
  public boolean offerLast(E e) {
    this.addLast(e);
    return true;
  }

  @Override
  public void push(E e) {
    addFirst(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    c.forEach(
        element -> {
          try {
            super.add(filter(c, element));
          } catch (IllegalArgumentException e) {
            err.println(String.format("Element %s has not been added to the collection", element));
          }
        });
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    List<E> filteredList = new ArrayList();
    for (E element : c) {
      try {
        filteredList.add(filter(c, element));
      } catch (IllegalArgumentException e) {
        err.println(String.format("Element %s has not been added to the collection", element));
      }
    }
    return super.addAll(index, filteredList);
  }

  private E filter(Collection<? extends E> c, E e) {
    return this.advancedListFilter.filter(this, e);
  }
}
