package com.example.algorithm.topologicalsorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TopologicalSortingTest {

  @Test
  void testSort_An_Acyclic_Graph() {
    Integer[][] arr = new Integer[][] {{1, 0}, {1, 2}, {0, 2}};
    TopologicalSorting<Integer> topologicalSorting = new TopologicalSorting<>(arr);
    assertThat(topologicalSorting.getTopologicalSortingList()).containsExactly(2, 0, 1);
    assertThat(topologicalSorting.isCyclic()).isFalse();
  }

  @Test
  void testSort_A_Cyclic_Graph() {
    Integer[][] arr = new Integer[][] {{1, 0}, {1, 2}, {0, 2}, {2, 1}};
    TopologicalSorting<Integer> topologicalSorting = new TopologicalSorting<>(arr);
    assertThat(topologicalSorting.getTopologicalSortingList()).isEmpty();
    assertThat(topologicalSorting.isCyclic()).isTrue();
  }

  @Test
  void testSort_A_Acyclic_Graph_But_Its_Subgraph_Is_Cyclic() {
    Integer[][] arr = new Integer[][] {{1, 0}, {1, 2}, {0, 2}, {0, 1}};
    TopologicalSorting<Integer> topologicalSorting = new TopologicalSorting<>(arr);
    assertThat(topologicalSorting.getTopologicalSortingList()).isEmpty();
    assertThat(topologicalSorting.isCyclic()).isFalse();
  }
}
