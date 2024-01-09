import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Return the right side of the tree, including root. from top to bottom
 */


public class RightSideView {

    // for each level, only show the right most node
    // use bfs level order traversal
    public List<Integer> rightSideView(TreeNode root) {
       
        List<Integer> res = new ArrayList<Integer>();

        if (root == null)
            return res;

        bfs(root, res);

        return res;
        
    }

    private void bfs(TreeNode root, List<Integer> res) {
        
        
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                if (i == 0) res.add(cur.val);
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null) q.offer(cur.left);
            }
        }


    }
}
