import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// left right root
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {

        if (root == null) // base case
            return;

        dfs(root.left, result); // go left
        dfs(root.right, result); // go right
        result.add(root.val); // add to result

    }

    public List<Integer> postorderIt(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        if (root == null) 
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        stack.push(curr);

        while (curr != null && !stack.isEmpty()){
            if (curr.right != null && !result.contains(curr.right.val)){
                stack.push(curr.right);
            }
            if (curr.left != null && !result.contains(curr.left.val)){
                stack.push(curr.left);
                curr = curr.left;
                break;
            }

            curr = stack.pop();
            result.add(curr.val);
            
        }

        return result;

    }
}
