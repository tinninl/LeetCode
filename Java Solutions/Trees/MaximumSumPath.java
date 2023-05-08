public class MaximumSumPath {

    // path doesnt have to go through root
    public int maxPathSum(TreeNode root) {

        if (root == null) 
            return 0;

        int[] res = {Integer.MIN_VALUE};
        maxPathSum(root, res);
        return res[0];

    }

    public int maxPathSum(TreeNode root, int[] res) {

        if (root == null) 
            return 0;

        int left = Math.max(0, maxPathSum(root.left, res));
        int right = Math.max(0, maxPathSum(root.right, res));
        res[0] = Math.max(res[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }              



}
