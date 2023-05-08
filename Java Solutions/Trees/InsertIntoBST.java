/**
 * guaranteed no duplicate elements
 */

public class InsertIntoBST {
    
    // Recursive implementation
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null){
            root = new TreeNode(val);
            return root;
        }

        else if (root.val > val)
            root.left = insertIntoBST(root.left, val);

        else if (root.val < val)
            root.right = insertIntoBST(root.right, val);

        return root;
    }

    // Iterative implementation
    public TreeNode insertIntoBST2(TreeNode root, int val) {

        if (root == null) 
            return new TreeNode(val);

        TreeNode curr = root;
        TreeNode prev = null;

        // Go through the tree until we hit the end (null)
        while (curr != null) {

            prev = curr; // update prev

            if (curr.val > val)
                curr = curr.left;
            
            else 
                curr = curr.right;

        }

        // Add the new node as the left or right child of prev
        if (prev.val > val)
            prev.left = new TreeNode(val);
        else
            prev.right = new TreeNode(val);

        return root;
 
    }
    
}
