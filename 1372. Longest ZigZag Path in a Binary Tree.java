//You are given the root of a binary tree.
//A ZigZag path for a binary tree is defined as follow:
//Choose any node in the binary tree and a direction (right or left).
//If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
//Change the direction from right to left or from left to right.
//Repeat the second and third steps until you can't move in the tree.
//Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
//Return the longest ZigZag path contained in that tree.

class Solution {
    int MAX;
    Map<TreeNode, int []> dp;
    public int longestZigZag(TreeNode root) {
        
        //postorder traversal
        //Map stores left from node and right from node
        dp = new HashMap<>();
        dfs(root);
        return MAX;
    }

    //returns max length from here if you go in a particular direction
    private void dfs(TreeNode root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            dp.put(root, new int[]{0,0});
            return;
        }
        //In dp value int []
        //index 0 represents left direction
        //index 1 represents right direction
        dfs(root.left);
        dfs(root.right);

        int left = 0, right = 0;

        if(dp.get(root.left) != null)
            left = 1 + dp.get(root.left)[1]; //we go right after left
        
        if(dp.get(root.right) != null)
            right = 1 + dp.get(root.right)[0]; //we go left after right
        dp.put(root, new int[]{left, right});
        MAX = Math.max(MAX, Math.max(left,right));
    }
}
