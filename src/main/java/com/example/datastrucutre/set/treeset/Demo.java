package com.example.datastrucutre.set.treeset;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Demo {
  public static void main(String[] args) {
    demoNavigableSetAttributes();
    demoSortedSetAttributes();
  }

  private static void demoNavigableSetAttributes() {
    NavigableSet<String> navigableSet = new TreeSet();
    navigableSet.add("Google");
    navigableSet.add("Amazon");
    navigableSet.add("Meta");
    navigableSet.add("Microsoft");

    System.out.println(navigableSet); // [Amazon, Google, Meta, Microsoft]
    System.out.println(navigableSet.higher("Google")); // Meta -> first item > Google
    System.out.println(navigableSet.higher("Microsoft")); // null
    System.out.println(navigableSet.ceiling("Google")); // Google -> first item >= Google
    System.out.println(navigableSet.ceiling("Microsoft")); // ceiling
    System.out.println(navigableSet.lower("Google")); // Amazon -> first item < Google
    System.out.println(navigableSet.lower("Amazon")); // null
    System.out.println(navigableSet.floor("Google")); // Amazon -> first item <= Google
    System.out.println(navigableSet.floor("Amazon")); // Amazon

    NavigableSet<String> reverseNavigateSet = navigableSet.descendingSet();
    System.out.println(navigableSet); // original: [Amazon, Google, Meta, Microsoft]
    System.out.println(reverseNavigateSet); // reverse: [Microsoft, Meta, Google, Amazon]
  }

  private static void demoSortedSetAttributes() {
    SortedSet<String> sortedSet = new TreeSet();
    sortedSet.add("Google");
    sortedSet.add("Amazon");
    sortedSet.add("Meta");
    sortedSet.add("Microsoft");
    System.out.println(sortedSet); // [Amazon, Google, Meta, microsoft]
    System.out.println(sortedSet.first()); // Amazon
    System.out.println(sortedSet.last()); // Microsoft
    System.out.println(
        sortedSet.headSet(
            "Meta123")); // [Amazon, Google, Meta] -> "Meta123" is after "Meta" lexicographically
    System.out.println(
        sortedSet.headSet("Meat")); // [Amazon, Google] -> "Meat" is before "Meta" lexicographically
    System.out.println(sortedSet.tailSet("Meta123")); // [Microsoft]
    System.out.println(sortedSet.tailSet("Meat")); // [Meta, Microsoft]
    System.out.println(sortedSet.subSet("Amazon", "Meta")); // [Amazon, Google]
  }
}
