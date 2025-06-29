//Given the root of a binary tree, return the inorder traversal of its nodes' values.

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res; 
    }

    static void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;

        inOrder(node.left, res);      // Left
        res.add(node.val);            // Node
        inOrder(node.right, res);     // Right
    }
}
