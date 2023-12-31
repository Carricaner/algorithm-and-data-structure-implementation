package com.example.datastructure.set.hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

  public static void main(String[] args) {
    demoSetAttributes();
  }

  private static void demoSetAttributes() {
    Set<String> set = new HashSet<>();
    set.add("Google");
    set.add("Apple");
    set.add("Meta");
    set.add("Nvidia");
    System.out.println(set); // [Google, Meta, Nvidia, Apple]

    set.add("Google");
    set.add("Nvidia");
    System.out.println(set); // [Google, Meta, Nvidia, Apple]

    System.out.println(set.contains("Google")); // true
    System.out.println(set.contains("Microsoft")); // false
    System.out.println(set.containsAll(Stream.of("Google").collect(Collectors.toSet()))); // true
    System.out.println(
        set.containsAll(Stream.of("Google", "TSMC").collect(Collectors.toSet()))); // false

    System.out.println(set.remove("Google")); // true
    System.out.println(set); // [Meta, Nvidia, Apple]
    System.out.println(set.remove("TSMC")); // false
    System.out.println(set); // [Meta, Nvidia, Apple]

    System.out.println(
        set.removeAll(
            Stream.of("Google", "Meta")
                .collect(Collectors.toSet()))); // true -> doest remove some items
    System.out.println(set); // [Nvidia, Apple]
    System.out.println(
        set.removeAll(
            Stream.of("Google", "Meta")
                .collect(Collectors.toSet()))); // false -> doesn't remove any item
    System.out.println(set); // [Nvidia, Apple]
    System.out.println(
        set.retainAll(
            Stream.of("Nvidia", "Meta")
                .collect(Collectors.toSet()))); // true -> does filter out some items
    System.out.println(set); // [Nvidia]
    System.out.println(
        set.retainAll(
            Stream.of("Nvidia")
                .collect(Collectors.toSet()))); // false -> doesn't filter out any items
    System.out.println(set); // [Nvidia]
  }
}
