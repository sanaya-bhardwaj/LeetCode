//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//Return the number of good nodes in the binary tree.

//CODE
class Solution {
    int count;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        count = 0;
        helper(root, root.val);
        return count;
    }

    public void helper(TreeNode root, int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            count++;
            max = root.val;
        }
        helper(root.left, max);
        helper(root.right, max);
    }
}

//Intuition
//In a binary tree, a "good" node is one whose value is greater than or equal to all the values from the root to that node.
//The goal is to count how many such good nodes exist. We can traverse the tree and keep track of the maximum value encountered so far on the path from the root to each node. 
//If a node's value is greater than or equal to this maximum, it's a good node.

//Approach
//Initialize a global count variable to keep track of good nodes.
//Use a helper function that performs a depth-first traversal of the tree.
//At each node, compare its value to the maximum value encountered so far:
//If the node's value is greater than or equal to the maximum, increment the count.
//Update the maximum value for the path when moving to child nodes.
//Recursively apply the same logic to the left and right subtrees.

//Complexity
//Time complexity:
//O(n), where n is the number of nodes in the tree, as each node is visited once.

//Space complexity:
//O(h), where h is the height of the tree.
//This is the space used by the recursion stack. 
//In the worst case, h = n for a skewed tree, and in the best case (balanced tree), O(logn)
