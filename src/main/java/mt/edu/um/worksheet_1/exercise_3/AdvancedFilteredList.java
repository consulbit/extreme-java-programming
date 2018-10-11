package mt.edu.um.worksheet_1.exercise_3;

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
    super.addFirst(filter(element));
  }

  @Override
  public void addLast(E element) {
    super.addLast(filter(element));
  }

  @Override
  public boolean add(E element) {
    return super.add(filter(element));
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    c.forEach(
        element -> {
          try {
            super.add(filter(element));
          } catch (IllegalArgumentException e) {
            err.println(String.format("Element %s has not been added to the collection", element));
          }
        });
    return true;
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
  public boolean addAll(int index, Collection<? extends E> c) {
    List<E> filteredList = new ArrayList<>();
    for (E element : c) {
      try {
        filteredList.add(filter(element));
      } catch (IllegalArgumentException e) {
        err.println(String.format("Element %s has not been added to the collection", element));
      }
    }
    return super.addAll(index, filteredList);
  }

  @Override
  public void add(int index, E element) {
    super.add(index, filter(element));
  }

  private E filter(E e) {
    return this.advancedListFilter.filter(this, e);
  }
}
