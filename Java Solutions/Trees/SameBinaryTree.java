public class SameBinaryTree {
    
    public boolean isSameTree(TreeNode p, TreeNode q){

        // Base case: both nodes are null
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        // Check if the left and right subtrees are the same
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        // The tree is the same if BOTH left and right subtrees are the same
        return left && right;
        
    }
    
}
