package com.example.unionfind;

import java.util.Arrays;

public class DisjointSet {
  private final int[] parent;
  private boolean hasCycle = false;

  public DisjointSet(int[][] edges) {
    parent = new int[getMax(edges) + 1];
    Arrays.fill(parent, -1);
    for (int[] edge : edges) {
      parent[edge[0]] = edge[0];
      parent[edge[1]] = edge[1];
    }
    for (int[] edge : edges) {
      int src = find(edge[0]);
      int des = find(edge[1]);
      if (src == des) hasCycle = true;
      union(src, des);
    }
  }

  private int getMax(int[][] edges) {
    int max = 0;
    for (int[] edge : edges) {
      max = Math.max(max, edge[0]);
      max = Math.max(max, edge[1]);
    }
    return max;
  }

  // A utility function to find the subset of an element i
  private int find(int i) {
    if (parent[i] == i) return i;
    return find(parent[i]);
  }

  // A utility function to do union of two subsets
  private void union(int x, int y) {
    parent[x] = y;
  }

  public int subsetSize() {
    int result = 0;
    for (int i = 0; i < parent.length; i++) {
      if (i == parent[i]) result++;
    }
    return result;
  }

  public boolean hasCycle() {
    return hasCycle;
  }
}
