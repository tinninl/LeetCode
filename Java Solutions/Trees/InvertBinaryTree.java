/**
 * 
 *  1 4 7 1 3 6 9
 * 
 *  1 7 4 9 6 3 1
 * 
 *  return root
 */


public class InvertBinaryTree {
    
    // Apply dfs to invert the tree 
    public TreeNode invertTree(TreeNode root){

        // Base case
        if (root == null)
            return null;
        
        // Swap the left and right nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert the left and right subtrees of root
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
