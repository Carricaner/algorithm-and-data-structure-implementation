package com.example.datastructure.disjointset;

import com.example.datastructure.disjointset.DisjointSetInnerStoreManager.DisjointSetInnerDataStoreType;
import java.util.Arrays;
import java.util.List;

public class DisjointSet {
  private final UnionFindable innerDataStore;

  private final DisjointSetInnerDataStoreType innerDataStoreDisjointSetInnerDataStoreType;

  public DisjointSet(int[][] edges) {
    this.innerDataStoreDisjointSetInnerDataStoreType = DisjointSetInnerDataStoreType.ARRAY;
    this.innerDataStore =
        DisjointSetInnerStoreManager.getDisjointInnerDataStructure(edges,
            innerDataStoreDisjointSetInnerDataStoreType);
  }

  public DisjointSet(int[][] edges, DisjointSetInnerDataStoreType innerDataStoreDisjointSetInnerDataStoreType) {
    this.innerDataStoreDisjointSetInnerDataStoreType = innerDataStoreDisjointSetInnerDataStoreType;
    this.innerDataStore =
        DisjointSetInnerStoreManager.getDisjointInnerDataStructure(edges,
            innerDataStoreDisjointSetInnerDataStoreType);
  }

  private boolean isContinuous(int[][] edges) {
    // flatten, distinguish and sort the array
    List<Integer> list =
        Arrays.stream(edges).flatMapToInt(Arrays::stream).boxed().distinct().sorted().toList();
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) - list.get(i - 1) != 1) {
        return false;
      }
    }
    return true;
  }

  public int findParent(int node) {
    return innerDataStore.find(node);
  }

  public int subsetNumber() {
    return innerDataStore.subnetNumber();
  }

  public boolean hasCycle() {
    return innerDataStore.hasCycle();
  }
}
