package com.example.topologicalsorting;

public class Demo {

  public static void main(String[] args) {
    Integer[][] arr = new Integer[][] {{1, 0}, {1, 2}};
    TopologicalSorting<Integer> topologicalSorting = new TopologicalSorting<>(arr);
    System.out.println(topologicalSorting.getTopologicalSortingList());
  }
}
