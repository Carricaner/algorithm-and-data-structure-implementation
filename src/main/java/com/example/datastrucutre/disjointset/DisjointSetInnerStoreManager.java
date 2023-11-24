package com.example.datastrucutre.disjointset;

public class DisjointSetInnerStoreManager {

  private DisjointSetInnerStoreManager() {
  }

  static public UnionFindable getDisjointInnerDataStructure(int[][] relations) {
    return getDisjointInnerDataStructure(relations, null);
  }

  static public UnionFindable getDisjointInnerDataStructure(int[][] relations, Type type) {
    if (type == null || type == Type.ARRAY) {
      return new DisjointSetInnerArrayDataStore(relations);
    } else {
      return new DisjointSetInnerMapDataStore(relations);
    }
  }

  enum Type {
    ARRAY(),
    MAP();
  }
}
