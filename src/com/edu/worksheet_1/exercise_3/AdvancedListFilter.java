package com.edu.worksheet_1.exercise_3;

import java.util.List;

/**
 * Created by Pietro Cascio on 06/10/2018
 */
@FunctionalInterface
public interface AdvancedListFilter<E> {

  E filter(List<E> list, E element) throws IllegalArgumentException;
}
