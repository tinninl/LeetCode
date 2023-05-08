import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Apply Breadth First Search
public class LevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> level;
        int len;
        TreeNode curr;

        if (root == null) 
            return res;

        queue.add(root);

        while (!queue.isEmpty()) {

            len = queue.size();
            level = new ArrayList<>();

            // Remove all elements from the queue and put them into the level
            for (int i = 0; i < len; i++) {

                curr = queue.poll();
                level.add(curr.val);

                // Add the left and right children to the queue
                if (curr.left != null) 
                    queue.add(curr.left);
                
                if (curr.right != null) 
                    queue.add(curr.right);
                
            }

            if (level != null)
                res.add(level);

        }

        return res;

    }

}
