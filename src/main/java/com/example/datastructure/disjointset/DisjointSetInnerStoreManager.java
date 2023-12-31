package com.example.datastructure.disjointset;

public class DisjointSetInnerStoreManager {

  private DisjointSetInnerStoreManager() {}

  public static UnionFindable getDisjointInnerDataStructure(int[][] relations) {
    return getDisjointInnerDataStructure(relations, null);
  }

  public static UnionFindable getDisjointInnerDataStructure(
      int[][] relations, DisjointSetInnerDataStoreType disjointSetInnerDataStoreType) {
    if (disjointSetInnerDataStoreType == null
        || disjointSetInnerDataStoreType == DisjointSetInnerDataStoreType.ARRAY) {
      return new DisjointSetInnerArrayDataStore(relations);
    } else {
      return new DisjointSetInnerMapDataStore(relations);
    }
  }

  enum DisjointSetInnerDataStoreType {
    ARRAY(),
    MAP();
  }
}
