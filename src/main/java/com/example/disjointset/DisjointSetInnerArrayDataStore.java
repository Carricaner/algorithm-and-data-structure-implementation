package com.example.disjointset;

import java.util.Arrays;

public class DisjointSetInnerArrayDataStore implements UnionFindable{
  private final int[] parent;
  private final int[] rank;
  private boolean hasCycle = false;

  public DisjointSetInnerArrayDataStore(int[][] edges) {
    parent = new int[getMax(edges) + 1];
    rank = new int[getMax(edges) + 1];
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

  @Override
  public int find(int i) {
    if (parent[i] == i) return i;
    return find(parent[i]);
  }

  @Override
  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if (rootX == rootY) {
      return;
    }

    if (rank[rootX] < rank[rootY]) {
      parent[rootX] = rootY;
    } else if (rank[rootX] > rank[rootY]) {
      parent[rootY] = rootX;
    } else {
      parent[rootY] = rootX;
      rank[rootX]++;
    }
  }

  @Override
  public int subnetNumber() {
    int result = 0;
    for (int i = 0; i < parent.length; i++) {
      if (i == parent[i]) result++;
    }
    return result;
  }

  @Override
  public boolean hasCycle() {
    return hasCycle;
  }
}
