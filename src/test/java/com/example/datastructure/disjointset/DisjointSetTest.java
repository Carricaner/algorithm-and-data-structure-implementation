package com.example.datastructure.disjointset;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.datastructure.disjointset.DisjointSetInnerStoreManager.DisjointSetInnerDataStoreType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DisjointSetTest {

  @Nested
  class InnerArrayDataStore {
    @Test
    void testDisjointSet_Given_An_Acyclic_Graph() {
      int[][] edges = new int[][] {{0, 1}, {1, 2}};
      DisjointSet djs = new DisjointSet(edges);
      assertThat(djs.hasCycle()).isFalse();
    }

    @Test
    void testDisjointSet_Given_A_Cyclic_Graph() {
      int[][] edges = new int[][] {{0, 1}, {1, 2}, {0, 2}};
      DisjointSet djs = new DisjointSet(edges);
      assertThat(djs.hasCycle()).isTrue();
    }

    @Test
    void testDisjointSet_Return_Multiple_Subsets() {
      int[][] edges = new int[][] {{0, 1}, {1, 2}, {0, 2}, {3, 4}, {5, 6}, {5, 7}};
      DisjointSet djs = new DisjointSet(edges);
      assertThat(djs.subsetNumber()).isEqualTo(3);
    }
  }

  @Nested
  class InnerMapDataStore {
    @Test
    void testDisjointSet_Given_An_Acyclic_Graph() {
      int[][] edges = new int[][] {{0, 1}, {1, 2}};
      DisjointSet djs = new DisjointSet(edges, DisjointSetInnerDataStoreType.MAP);
      assertThat(djs.hasCycle()).isFalse();
    }

    @Test
    void testDisjointSet_Given_A_Cyclic_Graph() {
      int[][] edges = new int[][] {{0, 1}, {1, 2}, {0, 2}};
      DisjointSet djs = new DisjointSet(edges, DisjointSetInnerDataStoreType.MAP);
      assertThat(djs.hasCycle()).isTrue();
    }

    @Test
    void testDisjointSet_Return_Multiple_Subsets() {
      int[][] edges = new int[][] {{0, 1}, {1, 2}, {0, 2}, {3, 4}, {5, 6}, {5, 7}};
      DisjointSet djs = new DisjointSet(edges, DisjointSetInnerDataStoreType.MAP);
      assertThat(djs.subsetNumber()).isEqualTo(3);
    }
  }
}
