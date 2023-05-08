//root, left, right

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

     public List<Integer> preorderRec(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        dfs(root, result);
        return result;
     }

     private void dfs(TreeNode node, List<Integer> result){
        if (node == null) return;
        result.add(node.val);
        dfs(node.left, result);
        dfs(node.right, result);
     }

    public List<Integer> preorderIt(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode curr = stack.pop();
            result.add(curr.val); // add node to result

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
           
            
        }

        return result;

    }


}
