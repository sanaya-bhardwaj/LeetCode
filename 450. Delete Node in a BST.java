//Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
//Return the root node reference (possibly updated) of the BST.
//Basically, the deletion can be divided into two stages:
//Search for a node to remove.
//If the node is found, delete the node.


class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        //search
        if(root == null ) {
            return null;
        }
        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val>key) {
            root.left = deleteNode(root.left,key);
        }
        else{
            //case 1: leaf node
            if(root.left == null && root.right == null ) {
                return null;
            }
            //case 2 : one child
            if(root.left ==  null){
                return root.right;
            }
            else if(root.right ==  null ) {
                return root.left;
            }
            //case 3 : two children
            TreeNode IS = findInOrderSuccessor(root.right);
            root.val = IS.val;

            
            root.right = deleteNode(root.right,IS.val);
        }
        return root;

    }
    private TreeNode findInOrderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}

 
