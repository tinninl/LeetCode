/**
 * “The lowest common ancestor is defined between two nodes p and q 
 * as the lowest node in T that has both p and q as descendants 
 * (where we allow a node to be a descendant of itself).”
 * 
 * guaranteed that p and q are in the tree and each node is unique
 */

public class LCAofBinaryTree {

    // Trace the path from root down to p and q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Base case
        if (root == null) 
            return null;

        // Root is guaranteed to be the LCA
        TreeNode LCA = root;
        
        // If both p and q are less than or greater than root, 
        // then the path continues left or right
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        else if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        else // the path splits to left and right, and we found the LCA
            return LCA;
        
    }

    // Note: just return root, why make new variable?

}
