//Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums,0,nums.length-1);
    }
    private static TreeNode CreateBST(int arr[] , int st , int end){
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2 ;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = CreateBST(arr, st, mid-1);
        root.right = CreateBST(arr, mid+1, end);
        return root;
    }
}
