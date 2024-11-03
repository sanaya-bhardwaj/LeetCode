//You are given the root of a binary search tree (BST) and an integer val.
//Find the node in the BST that the node's value equals val and return the subtree rooted with that node. 
//If such a node does not exist, return null.

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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }

        if(root.val==val){
            return root;
        }
        
        TreeNode left = searchBST(root.left,val);
        TreeNode right = searchBST(root.right,val);

        //return which is not null or return null
        return left!=null?left:right;
        
    }
}
