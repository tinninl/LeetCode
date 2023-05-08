/** max and min depth are at least one level apart */
// use soln from maxDepth problem

public class BalancedBinaryTree {

    boolean result = true;

    // We need a helper function to find the depths of the left and right subtrees
    public boolean isBalanced(TreeNode root){
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root){

        if (root == null)
            return 0;

        // What is the maxDepth of the left and right subtrees?
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // If the depths are too far apart, its not balanced
        if (Math.abs(left - right) > 1)
            result = false;

        // Return the maxDepth of root
        return 1 + Math.max(left, right);
        
    }

}
