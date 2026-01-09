//Given the root of a binary tree, the depth of each node is the shortest distance to the root.
//Return the smallest subtree such that it contains all the deepest nodes in the original tree.
//A node is called the deepest if it has the largest depth possible among any node in the entire tree.
//The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

class Solution {
    class Result {
        int height;
        TreeNode node;
        Result(int h, TreeNode n) {
            height = h;
            node = n;
        }
    }

    private Result dfs(TreeNode node) {
        if (node == null) return new Result(0, null);
        
        Result left = dfs(node.left);
        Result right = dfs(node.right);
        
        if (left.height > right.height) {
            return new Result(left.height + 1, left.node);
        } else if (right.height > left.height) {
            return new Result(right.height + 1, right.node);
        } else {
            return new Result(left.height + 1, node);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}
