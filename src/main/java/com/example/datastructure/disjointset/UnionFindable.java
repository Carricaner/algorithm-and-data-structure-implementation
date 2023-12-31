package com.example.datastructure.disjointset;

public interface UnionFindable {
  int find(int i);
  int subnetNumber();
  boolean hasCycle();
}
