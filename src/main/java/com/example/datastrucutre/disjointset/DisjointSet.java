package com.example.datastrucutre.disjointset;

import com.example.datastrucutre.disjointset.DisjointSetInnerStoreManager.Type;
import java.util.Arrays;
import java.util.List;

public class DisjointSet {
  private final UnionFindable innerDataStore;

  public DisjointSet(int[][] edges) {
    DisjointSetInnerStoreManager.Type type = isContinuous(edges) ? Type.ARRAY : Type.MAP;
    innerDataStore = DisjointSetInnerStoreManager.getDisjointInnerDataStructure(edges, type);
  }

  private boolean isContinuous(int[][] edges) {
    // flatten, distinguish and sort the array
    List<Integer> list = Arrays.stream(edges)
        .flatMapToInt(Arrays::stream)
        .boxed().distinct().sorted().toList();
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) - list.get(i - 1) != 1) {
        return false;
      }
    }
    return true;
  }


  public int subsetNumber() {
    return innerDataStore.subnetNumber();
  }

  public boolean hasCycle() {
    return innerDataStore.hasCycle();
  }
}
