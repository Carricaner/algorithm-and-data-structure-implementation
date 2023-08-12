import com.example.disjointset.DisjointSet;

public class Demo {
  public static void main(String[] args) {
    // Driver Method
    /* Let us create the following graph
    0
    | \
    |  \
    1---2 */
    int[][] edges =
        new int[][] {
          {0, 1},
          {1, 2},
          {4, 5},
        };
    DisjointSet djs = new DisjointSet(edges);
    System.out.println(djs.subsetNumber());
    System.out.println(djs.hasCycle());
  }
}
