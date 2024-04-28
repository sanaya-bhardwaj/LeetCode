//There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
//You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
//Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

class Solution {
  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    int[] ans = new int[n];
    int[] count = new int[n];
    Set<Integer>[] tree = new Set[n];

    Arrays.fill(count, 1);

    for (int i = 0; i < n; ++i)
      tree[i] = new HashSet<>();

    for (int[] edge : edges) {
      final int u = edge[0];
      final int v = edge[1];
      tree[u].add(v);
      tree[v].add(u);
    }

    postorder(tree, 0, -1, count, ans);
    preorder(tree, 0, -1, count, ans);
    return ans;
  }

  private void postorder(Set<Integer>[] tree, int node, int parent, int[] count, int[] ans) {
    for (final int child : tree[node]) {
      if (child == parent)
        continue;
      postorder(tree, child, node, count, ans);
      count[node] += count[child];
      ans[node] += ans[child] + count[child];
    }
  }

  private void preorder(Set<Integer>[] tree, int node, int parent, int[] count, int[] ans) {
    for (final int child : tree[node]) {
      if (child == parent)
        continue;
      // count[child] nodes are 1 step closer from child than parent.
      // (n - count[child]) nodes are 1 step farther from child than parent.
      ans[child] = ans[node] - count[child] + (tree.length - count[child]);
      preorder(tree, child, node, count, ans);
    }
  }
}
