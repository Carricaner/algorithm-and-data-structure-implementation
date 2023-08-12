package com.example.disjointset;

import com.example.disjointset.DisjointSet;

public class Demo {
  public static void main(String[] args) {
    int[][] edges =
        new int[][] {
          {0, 1},
          {1, 2},
          {2, 0},
        };
    DisjointSet djs = new DisjointSet(edges);
    System.out.println(djs.subsetNumber());
    System.out.println(djs.hasCycle());
  }
}
