import com.example.unionfind.DisjointSet;

public class Demo {
  public static void main(String[] args) {
    // Driver Method
    /* Let us create the following graph
    0
    | \
    |  \
    1---2 */
    int[][] edges = new int[][] {
        {0, 1},
        {1, 2},
        {2, 0},
    };
    DisjointSet djs = new DisjointSet(edges);
    System.out.println(djs.subsetSize());
    System.out.println(djs.hasCycle());
  }
}
