/**
 * path from root to x has no values greater than x = good node
 */

public class CountGoodNodes {

    // Process each node before checking left and right = preorder traversal question
    // We need to also pass the max value in the path = we need a helper function
    public int goodNodes(TreeNode root){

        if (root == null)
            return 0;

        return dfs(root, root.val);
      
    }

    private int dfs(TreeNode node, int max){

        if (node == null)
            return 0;

        int res; // number of good nodes
        
        // Process the node, is it greater than the max value in the path so far?
        if (node.val >= max){
            res = 1;    
            max = node.val;  
        }

        else
            res = 0;

        // Check the left and right subtrees
        res += dfs(node.left, max);
        res += dfs(node.right, max);

        return res;

    }
    
}
