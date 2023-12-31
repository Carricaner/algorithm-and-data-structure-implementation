package com.example.algorithm.topologicalsorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class TopologicalSorting<T> {
  private final Map<T, Integer> indegreeMap;
  private final Map<T, List<T>> topoMap;
  private final List<T> topologicalSortingList = new ArrayList<>();

  TopologicalSorting(T[][] relations) {
    indegreeMap = new HashMap<>();
    topoMap = new HashMap<>();
    init(relations);
  }

  private void init(T[][] relations) {
    if (relations == null) {
      return;
    }
    for (T[] relation : relations) {
      indegreeMap.put(relation[0], indegreeMap.getOrDefault(relation[0], 0) + 1);
      indegreeMap.putIfAbsent(relation[1], 0);
      topoMap.computeIfAbsent(relation[1], key -> new ArrayList<>()).add(relation[0]);
      topoMap.putIfAbsent(relation[0], new ArrayList<>());
    }
  }

  public boolean isCyclic() {
    return indegreeMap.entrySet().stream().noneMatch(entry -> entry.getValue() == 0);
  }

  public List<T> getTopologicalSortingList() {
    if (!topologicalSortingList.isEmpty()) {
      return topologicalSortingList;
    }
    if (isCyclic()) {
      return new ArrayList<>();
    }
    List<T> res = new ArrayList<>();
    Queue<T> queue = new LinkedList<>();
    indegreeMap.forEach(
        (key, value) -> {
          if (value == 0) {
            queue.offer(key);
          }
        });
    while (!queue.isEmpty()) {
      T poll = queue.poll();

      // To check whether the current node is the one without any in-degree
      if (indegreeMap.get(poll) != 0) {
        return new ArrayList<>();
      }

      for (T target : topoMap.get(poll)) {
        indegreeMap.put(target, indegreeMap.get(target) - 1);
        if (indegreeMap.get(target) == 0) {
          queue.offer(target);
        }
      }
      res.add(poll);
    }

    // This part is to check whether all the in-degrees are removed after the traversal.
    // If not, it means there is a sub-cycle inside.
    for (Entry<T, Integer> entry : indegreeMap.entrySet()) {
      if (entry.getValue() > 0) return new ArrayList<>();
    }

    return res;
  }
}
