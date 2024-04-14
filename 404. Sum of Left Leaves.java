//Given the root of a binary tree, return the sum of all left leaves.
//A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
      return 0;

    int ans = 0;

    if (root.left != null) {
      if (root.left.left == null && root.left.right == null)
        ans += root.left.val;
      else
        ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);

    return ans;
  }
}
