package mt.edu.um.lesson_4;

import static org.apache.commons.lang3.BooleanUtils.isFalse;
import static org.apache.commons.lang3.BooleanUtils.isTrue;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise_16 {

  public static void main(String[] args) {
    final Random randomizer = new Random();
    Stream<Integer> ints = Stream.generate(() -> randomizer.nextInt(99999))
        .limit(20);
//    Partition it into odd and even numbers using the partitionBy(). Print the even
//    numbers first followed by the odd ones.
    Map<Boolean, List<Integer>> oddEvenPartion = ints
        .collect(Collectors.partitioningBy(n -> ((n % 2) == 0)));

    oddEvenPartion.entrySet().stream()
        .filter(entry -> isTrue(entry.getKey()))
        .map(Entry::getValue)
        .forEach(System.out::print);

    oddEvenPartion.entrySet().stream()
        .filter(entry -> isFalse(entry.getKey()))
        .map(Entry::getValue)
        .forEach(System.out::print);

    // Group them by the last digit. (i.e. if a number is 15 its key should be 5, if a number is 29,
    // its key should be 9). Print the grouped numbers (you can just print the map).
    // Hint: You can use the mod operator % to divide by 10 and get the last digit.
    Stream<Integer> ints2 = Stream.generate(() -> randomizer.nextInt(99999))
        .limit(20);
    ints2.collect(Collectors.groupingBy(integer -> integer % 10))
        .forEach(Exercise_16::printKeyValueListPair);
  }

  private static void printKeyValuePair(Integer key, Integer value) {
    System.out.printf("[%s]: %s%n", key, value);
  }

  private static void printKeyValueListPair(Integer key, List<Integer> value) {
    System.out.printf("[%s]: %s%n", key, value);
  }

  private static void printKeyValueListPair(Boolean key, List<Integer> value) {
    System.out.printf("[%s]: %s%n", key, value);
  }
}
