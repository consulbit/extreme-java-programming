package mt.edu.um.lesson_2.worksheet_2.exercise_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>LAS3006 – Worksheet 2 – Introduction to Streams</h1>
 *
 * <h2>Exercise 2</h2>
 *
 * <p>
 *
 * <ol>
 * <li><strong>Write a simple keyword filter that filters out stop words and duplicates.</strong>
 * <p>"Stop words" are words which are used in a lot of sentences and thus do not contain
 * significant information with regards to search queries. You are required to filter them out of a
 * stream of words, in order to identify the significant keywords.
 * <ol type="a">
 * <li>Create a list of stop words. You can use <strong>Arrays.asList()</strong> and pass a
 * list of English stop words such as: <br>
 * <i>"a", "an", "the", "so", "it", "do", "did",
 * "for", "by", "of", "to"</i>
 * <li>Prompt the user to enter a list of words, typing enter after each word. If the user
 * types enter without entering a line it means he is ready from his word list. Put these in an
 * appropriate collection, such as a
 * <strong>LinkedList&lt;String&gt;</strong>.
 * <li>Stream the list of words entered by the user and filter out any stop words and
 * duplicates, and print them out sorted in <strong>descending order.</strong>
 * </ol>
 * </ol>
 *
 * Created by Pietro Cascio on 15/10/2018
 */
public class Exercise_2 {

  public static void main(String[] args) {
    List<String> stopWords =
        Arrays.asList("a", "an", "the", "so", "it", "do", "did", "for", "by", "of", "to");
    List<String> userWords = new LinkedList<>();

    Scanner scanner = new Scanner(System.in);
    String userWord;
    System.out.println(
        "Enter a list of word, press enter after each word (press enter without typing any word to finish): ");
    while (!"".equals(userWord = scanner.nextLine())) {
      userWords.add(userWord);
    }
    userWords.stream()
        .distinct()
        .filter(word -> !stopWords.contains(word))
        .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
  }
}
