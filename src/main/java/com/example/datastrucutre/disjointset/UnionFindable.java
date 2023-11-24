package com.example.datastrucutre.disjointset;

public interface UnionFindable {
  int find(int i);
  void union(int x, int y);
  int subnetNumber();
  boolean hasCycle();
}