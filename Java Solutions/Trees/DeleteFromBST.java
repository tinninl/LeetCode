public class DeleteFromBST {
    
    public TreeNode deleteNode(TreeNode root, int key){
        
        TreeNode curr;

        if (root == null)
            return root;

        if (root.val > key)
            deleteNode(root.left, key);       

        else if (root.val < key)
            deleteNode(root.right, key);
        
        // target is found
        else {

            if (root.left == null)
                return root.right;
            
            else if (root.right == null)
                return root.left;

            // Find the min from right subtree
            curr = root.right;
            while (curr.left != null)
                curr = curr.left;
            
            root.val = curr.val;
            root.right = deleteNode(root.right, root.val);

        }

        return root;

    }

}
