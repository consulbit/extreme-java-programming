package mt.edu.um.lesson_1.worksheet_1.exercise_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>Advanced List Filtering using Lambda Expressions</h1>
 *
 * <p>In this exercise you are going to create a more advanced List&lt;&gt; implementation which
 * not only accepts elements that satisfy certain criteria, but also offers the possibility for
 * these criteria to be based on the existent elements of the list, and also to modify the element
 * being added to the list.
 *
 * <ul>
 * <li>a) Create a new class named <strong>AdvancedFilteredList&lt;E&gt;</strong> that extends
 * <strong>LinkedList&lt;E&gt;</strong>. As its constructor argument, the
 * <strong>FilteredList&lt;E&gt;</strong> must take a functional interface whise method takes
 * a <strong>List&lt;E&gt;</strong> representing the current contents of the list, the new element
 * of type <strong>E</strong>, and returns <strong>E</strong>, to be added to the list (which could
 * be a different value). The method should also throw
 * <strong>IllegalArgumentException</strong>, in case nothing should be added to the list.
 * <p><strong>Hint:</strong> You can call this functional interface
 * <strong>AdvancedListFilter&lt;E&gt;</strong>, having one method with signature <strong>E
 * filter(List&lt;&gt;, E)</strong>. Do not forget the <strong>@FunctionalInterface</strong>
 * </ul>
 *
 * Created by Pietro Cascio on 06/10/2018
 */
public class AdvancedFilterListTest {

  private static AdvancedListFilter<Integer> filterFunction =
      (list, element) -> {
        int newElement;
        // Check if element is negative
        if (element < 0) {
          newElement = Math.abs(element);
        } else {
          newElement = element;
        }
        list.forEach(
            listElement -> {
              int module = newElement % listElement;
              if (module == 0) {
                throw new IllegalArgumentException("The element cannot be accepted");
              }
            });
        return newElement;
      };

  public static void main(String[] args) {
    AdvancedFilteredList advancedFilteredList = new AdvancedFilteredList(filterFunction);

    List<Integer> seed = new ArrayList<>(Arrays.asList(81, 9, 27, -5, 14, 15, 3, -6));
    advancedFilteredList.addAll(seed);

    advancedFilteredList.forEach(System.out::println);
  }
}
