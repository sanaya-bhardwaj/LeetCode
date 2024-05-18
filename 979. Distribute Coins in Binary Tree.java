//You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
//In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
//Return the minimum number of moves required to make every node have exactly one coin.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int distributeCoins(TreeNode root) {
    dfs(root);
    return ans;
  }

  private int ans = 0;

  // Returns the number of coins I can give (positive) / take (negative).
  private int dfs(TreeNode root) {
    if (root == null)
      return 0;

    final int l = dfs(root.left);
    final int r = dfs(root.right);
    ans += Math.abs(l) + Math.abs(r);

    return (root.val - 1) + l + r;
  }
}
