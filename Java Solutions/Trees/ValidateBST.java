import java.util.Stack;

public class ValidateBST {
    
    public boolean isValidBST(TreeNode root){

        if (root == null)    
            return true;

        return dfs(root, null, null);

    }

    private boolean dfs(TreeNode root, Integer min, Integer max){

        if (root == null)    
            return true;

        if (min != null && root.val <= min)
            return false;

        if (max != null && root.val >= max)
            return false;

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}

}
