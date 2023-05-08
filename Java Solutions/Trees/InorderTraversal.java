import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * left, root, right
 *      
 *      A
 *     b  c
 *    d e f g
 * 
 * res = d b e a f c g
 */

public class InorderTraversal {
    
    // Iterative implementation
    public List<Integer> inorderIterative(TreeNode root){

        List<Integer> res = new ArrayList<Integer>();

        TreeNode curr = root;

        if (curr == null)
            return res;

        Stack<TreeNode> s = new Stack<TreeNode>();

        while (!s.empty() || curr != null){

            // Add the left nodes
            while (curr != null){
                s.push(curr);
                curr = curr.left;
            }

            // Pop and add to result
            curr = s.pop();
            res.add(curr.val);

            // Move to right node
            curr = curr.right;
        }
        

        return res;

    }

    public List<Integer> inorderRec(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res){

        // Base case
        if (node == null)
            return;

        dfs(node.left, res); // go left
        res.add(node.val); // add root
        dfs(node.right, res); // go right
        
    }
}


