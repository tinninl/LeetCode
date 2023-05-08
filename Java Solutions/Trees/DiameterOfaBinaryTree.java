// The longest distance between any two nodes
public class DiameterOfaBinaryTree {
    
    int res = -1;
    public int diameterOfBinaryTree(TreeNode root){

        
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node){
        if (node == null)
            return -1;
        int leftHeight = 1 + dfs(node.left);
        int rightHeight = 1 + dfs(node.right);
        res = Math.max(res, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight); 
    }
}
