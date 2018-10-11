package main.java.mt.edu.um.worksheet_1.exercise_2;

import static java.lang.System.err;
import static java.lang.System.out;

import java.util.Random;
import java.util.function.Predicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Created by Pietro Cascio on 06/10/2018
 */
class FilteredListTest {

  private static final int INITIAL_CAPACITY = 10;
  private static final int MAX_INT = 100;
  private static final int INDEX = 2;
  private final Random randomizer = new Random();

  private final Predicate<Integer> predicate = element -> element < 50;
  private FilteredList<Integer> testList;
  private Predicate<Integer> isEvenPredicate = generatedNumber -> (generatedNumber % 2 == 0);

  @BeforeEach
  public void setUp() {
    testList = new FilteredList<>(e -> true);
    for (int i = 0; i < INITIAL_CAPACITY; i++) {
      try {
        testList.add(randomizer.nextInt(MAX_INT));
      } catch (IllegalStateException e) {
        System.out.println(e.getMessage());
      }
      testList.forEach(out::println);
    }
    testList.setPredicate(predicate);
  }

  @Disabled
  @Test
  void offer() {
  }

  @Disabled
  @Test
  void offerLast() {
  }

  @Disabled
  @Test
  void addAll() {
  }

  @Disabled
  @Test
  void addAll1() {
  }

  @Disabled
  @Test
  void offerFirst() {
  }

  @Disabled
  @Test
  void push() {
  }

  @Disabled
  @Test
  void addFirst() {
  }

  @Disabled
  @Test
  void addLast() {
  }

  @Test
  void shouldAddElementOnPredicateSuccessful() {
    int value = 48;
    testList.add(value);

    Assertions.assertEquals(INITIAL_CAPACITY + 1, testList.size());
  }

  @Test
  void shouldntAddElementOnPredicateFailure() {
    int value = 52;
    try {
      testList.add(value);
    } catch (IllegalArgumentException e) {
      err.println(e.getMessage());
    }
    Assertions.assertEquals(INITIAL_CAPACITY, testList.size());
  }

  @Test
  void shouldAddAtIndexIfPredicateSuccessful() {
    final int VALUE = 48;
    try {
      testList.add(INDEX, VALUE);
    } catch (IllegalArgumentException e) {
      err.println(e.getMessage());
    }

    Assertions.assertEquals(VALUE, testList.get(INDEX).intValue());
  }

  @Test
  void shouldntAddAtIndexIfPredicateFailure() {
    final int VALUE = 52;
    try {
      testList.add(INDEX, VALUE);
    } catch (IllegalArgumentException e) {
      err.println(e.getMessage());
    }

    Assertions.assertEquals(INITIAL_CAPACITY, testList.size());
  }

  @Test
  void shouldAcceptOnlyOddNumbers() {
    try {
      testList.add(addEvenNumber());
      Assertions.assertEquals(INITIAL_CAPACITY, testList.size());

      testList.add(addOddNumber());
      Assertions.assertEquals(INITIAL_CAPACITY + 1, testList.size());
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }
  }

  private int addEvenNumber() {
    int generatedNumber = randomizer.nextInt(100);
    while (!isEvenPredicate.test(generatedNumber)) {
      generatedNumber = randomizer.nextInt(100);
    }
    return generatedNumber;
  }

  private int addOddNumber() {
    int generatedNumber = randomizer.nextInt(100);

    while (isEvenPredicate.test(generatedNumber)) {
      generatedNumber = randomizer.nextInt(100);
    }
    return generatedNumber;
  }

  @Test
  void shouldntAcceptEvenNumbers() {
    try {
      testList.add(addEvenNumber());
      Assertions.assertEquals(INITIAL_CAPACITY, testList.size());
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }
  }
}
