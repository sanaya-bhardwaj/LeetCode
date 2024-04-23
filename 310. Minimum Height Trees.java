//A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
//Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
//Return a list of all MHTs' root labels. You can return the answer in any order.
//The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 0 || edges.length == 0)
      return new ArrayList<>(Arrays.asList(0));

    List<Integer> ans = new ArrayList<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    for (int i = 0; i < n; ++i)
      graph.put(i, new HashSet<>());

    for (int[] edge : edges) {
      final int u = edge[0];
      final int v = edge[1];
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
      final int label = entry.getKey();
      Set<Integer> children = entry.getValue();
      if (children.size() == 1)
        ans.add(label);
    }

    while (n > 2) {
      n -= ans.size();
      List<Integer> nextLeaves = new ArrayList<>();
      for (final int leaf : ans) {
        final int u = (int) graph.get(leaf).iterator().next();
        graph.get(u).remove(leaf);
        if (graph.get(u).size() == 1)
          nextLeaves.add(u);
      }
      ans = nextLeaves;
    }

    return ans;
  }
}
