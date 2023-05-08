import java.util.Stack;

/**
 * 
 *  number of nodes in longest path
 *  3 nodes, two branches, return 3
 */

public class MaximumDepthofBinaryTree {

    // recursive dfs

    /**
     * base case: root = null
     * subproblem: whats the max depth of the left and right trees? which one is bigger
     */
    public int maxDepthdfs(TreeNode root){

        if (root == null)
            return 0;

        return 1 + Math.max(maxDepthdfs(root.left), maxDepthdfs(root.right));
        
    }

    // which traversal is best? pre, in, or post?

    public int maxDepthIterative(TreeNode root){

        if (root == null) return 0;

        // Use two stacks, one for nodes, and one for the depth of each node
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> t = new Stack<Integer>();

        s.push(root);
        t.push(1);

        int maxDepth = 0;

        while (!s.isEmpty()){

            TreeNode curr = s.pop();
            int depth = t.pop();

            maxDepth = Math.max(maxDepth, depth);

            if (curr.left != null){
                s.push(curr.left);
                t.push(depth + 1);
            }

            if (curr.right != null){
                s.push(curr.right);
                t.push(depth + 1);
            }
           
        }

        return maxDepth;
    }

}
