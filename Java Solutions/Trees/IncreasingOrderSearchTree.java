public class IncreasingOrderSearchTree {

    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {

        //create a dummy node
        TreeNode first = new TreeNode(-1);
        
        //assign first
        curr = first;
        
		//depth first search
        dfs(root);
        
        return first.right;
    }

    private void dfs(TreeNode node){

        if (node == null) return;
        
        //go to left child
        dfs(node.left);
        
        //create a new node, and assign to right
        curr.right = new TreeNode(node.val);
        
        //move the current pointer
        curr = curr.right;
        
        dfs(node.right);

    }
    
}
