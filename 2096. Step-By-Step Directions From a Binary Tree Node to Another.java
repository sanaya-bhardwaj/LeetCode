//You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. 
//You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.
//Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. 
  Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.



class Solution {
  public String getDirections(TreeNode root, int startValue, int destValue) {
    // Only this subtree matters.
    dfs(lca(root, startValue, destValue), startValue, destValue, new StringBuilder());
    return "U".repeat(pathToStart.length()) + pathToDest;
  }

  private String pathToStart = "";
  private String pathToDest = "";

  private TreeNode lca(TreeNode root, int p, int q) {
    if (root == null || root.val == p || root.val == q)
      return root;
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if (left != null && right != null)
      return root;
    return left == null ? right : left;
  }

  private void dfs(TreeNode root, int p, int q, StringBuilder path) {
    if (root == null)
      return;
    if (root.val == p)
      pathToStart = path.toString();
    if (root.val == q)
      pathToDest = path.toString();
    dfs(root.left, p, q, path.append('L'));
    path.deleteCharAt(path.length() - 1);
    dfs(root.right, p, q, path.append('R'));
    path.deleteCharAt(path.length() - 1);
  }
}
