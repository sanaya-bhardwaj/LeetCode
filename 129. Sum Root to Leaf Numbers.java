//You are given the root of a binary tree containing digits from 0 to 9 only.

//Each root-to-leaf path in the tree represents a number.

//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

//A leaf node is a node with no children.


class Solution {
  public int sumNumbers(TreeNode root) {
    dfs(root, 0);
    return ans;
  }

  private int ans = 0;

  private void dfs(TreeNode root, int path) {
    if (root == null)
      return;
    if (root.left == null && root.right == null) {
      ans += path * 10 + root.val;
      return;
    }

    dfs(root.left, path * 10 + root.val);
    dfs(root.right, path * 10 + root.val);
  }
}
