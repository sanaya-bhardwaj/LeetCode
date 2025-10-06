//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

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
    public boolean isSymmetric(TreeNode root) {
       if(root==null)return true;
       return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode nodeleft,TreeNode noderight){
        if(nodeleft==null&&noderight==null)return true;
        if(nodeleft==null||noderight==null)return false;
        return nodeleft.val==noderight.val && isMirror(nodeleft.left,noderight.right)&&isMirror(nodeleft.right,noderight.left);
    }
}
