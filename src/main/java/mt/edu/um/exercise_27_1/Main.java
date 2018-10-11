package main.java.mt.edu.um.exercise_27_1;

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;

/** Created by Pietro Cascio on 05/10/2018 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter directory path: ");
    String directoryPath = scanner.next();
    System.out.println("Enter file extension: ");
    String fileExt = scanner.next();

    Stream.of(requireNonNull(
        new File(directoryPath).listFiles((file -> file.getName().endsWith(fileExt)))))
        .forEach(System.out::println);
  }
}
