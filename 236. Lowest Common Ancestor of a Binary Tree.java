//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//According to the definition of LCA on Wikipedia: 
//“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as 
//descendants (where we allow a node to be a descendant of itself).”

class Solution {
    public static TreeNode out;
    public static boolean findit(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null)
            return false;
        
        boolean a = findit(root.left,p,q);
        boolean b = findit(root.right,p,q);
        
        
        if(root.val == p.val || root.val == q.val)   //if one of the value is itself lowest common ancestor
        {
            if(a||b)
                out = root;
            return true;
        }
        if(a&&b)  //if values are child of lowest common ancestor
        {
            out = root;
        }
        return a||b;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findit(root,p,q);
        return out;
    }
}
