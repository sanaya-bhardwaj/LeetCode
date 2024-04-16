//Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
//Note that the root node is at depth 1.
//The adding rule is:
//Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
//cur's original left subtree should be the left subtree of the new left subtree root.
//cur's original right subtree should be the right subtree of the new right subtree root.
//If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.


class Solution {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    }

    int depth = 0;
    Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));

    while (!q.isEmpty()) {
      ++depth;
      for (int sz = q.size(); sz > 0; --sz) {
        TreeNode node = q.poll();
        if (node.left != null)
          q.offer(node.left);
        if (node.right != null)
          q.offer(node.right);
        if (depth == d - 1) {
          TreeNode cachedLeft = node.left;
          TreeNode cachedRight = node.right;
          node.left = new TreeNode(v);
          node.right = new TreeNode(v);
          node.left.left = cachedLeft;
          node.right.right = cachedRight;
        }
      }
      if (depth == d - 1)
        break;
    }

    return root;
  }
}
