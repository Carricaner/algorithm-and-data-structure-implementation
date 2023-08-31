package com.example.topologicalsorting;

public class Demo {

  public static void main(String[] args) {
    Integer[][] arr = new Integer[][] {{1, 0}, {2, 0}, {3, 0}, {3, 1}, {3, 2}};
    TopologicalSorting<Integer> topologicalSorting = new TopologicalSorting<>(arr);
    System.out.println(topologicalSorting.getTopologicalSortingList());
  }
}
