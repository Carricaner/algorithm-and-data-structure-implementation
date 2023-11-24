package com.example.datastrucutre.disjointset;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DisjointSetInnerMapDataStore implements UnionFindable {
  private final Map<Integer, Integer> parent;
  private final Map<Integer, Integer> rank;
  private boolean hasCycle = false;

  public DisjointSetInnerMapDataStore(int[][] edges) {
    parent = new HashMap<>();
    rank = new HashMap<>();
    for (int[] edge : edges) {
      int src = find(edge[0]);
      int des = find(edge[1]);
      if (src == des) hasCycle = true;
      union(src, des);
    }
  }

  @Override
  public int find(int x) {
    if (!parent.containsKey(x)) {
      parent.put(x, x);
      rank.put(x, 0);
    }

    if (parent.get(x) != x) {
      parent.put(x, find(parent.get(x)));
    }
    return parent.get(x);
  }

  @Override
  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if (rootX == rootY) {
      return;
    }

    if (rank.get(rootX) < rank.get(rootY)) {
      parent.put(rootX, rootY);
    } else if (rank.get(rootX) > rank.get(rootY)) {
      parent.put(rootY, rootX);
    } else {
      parent.put(rootY, rootX);
      rank.put(rootX, rank.get(rootX) + 1);
    }
  }

  @Override
  public int subnetNumber() {
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : parent.entrySet()) {
      if (Objects.equals(entry.getValue(), entry.getKey())) {
        result++;
      }
    }
    return result;
  }

  @Override
  public boolean hasCycle() {
    return hasCycle;
  }
}
