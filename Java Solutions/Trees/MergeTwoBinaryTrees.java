public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        // Base case: both nodes are null
        if (root1 == null && root2 == null) 
            return null;

        // If only one node is null, then return the other one
        if (root1 == null)
            return root2;

        else if (root2 == null)
            return root1;
        
        // If both nodes are not null, then merge them
        else 
            root1.val = root1.val + root2.val;
        
        // Merge the left and right child
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
    
        return root1; // We could return root2 instead, just change some stuff

    }

}
