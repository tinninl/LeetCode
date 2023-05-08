public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        // Base cases:
        if (subRoot == null) return true;
        if (root == null) return false;

        // Check if the subroot and root are the same tree
        if (isSameTree(root, subRoot)) return true;

        // If not, check the left and right subtrees of root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    // Solution from SameBinaryTree problem on leetcode
    private boolean isSameTree(TreeNode p, TreeNode q){

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
        
    }

}
