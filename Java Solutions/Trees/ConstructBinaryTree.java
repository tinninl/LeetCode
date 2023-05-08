// Guaranteed to have unique values in the arrays

import java.util.Arrays;

public class ConstructBinaryTree {

    /**
     * 1. The first element in a preorder traversal is the root
     * 2. In the inorder traversal, all elements left of the root are in the left subtree
     * 
     * Idea:
     * 1. build the root
     * 2. build the left subtree and right subtree recursively
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;

       

        // Find the index of root in the inOrder array
        for (int i = 0; i < inorder.length; i++) 
            if (preorder[0] == inorder[i])
                mid = i;

        // start is inclusive, end is exclusive
        // partition the 2 arrays, look up array methods in java docs
        // expensive to use this method in time and memory
        root.left = 
            buildTree(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid)
            );

        root.right = 
            buildTree(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length)
                );

        /**
         * Ex. pre = [3 9 20 15 7] and in = [9 3 15 20 7]
         * root = 3, mid = 1
         * One node in left subtree, and 3 nodes in the right subtree
         * root.left = preorder [1:2] and inorder[0:1] (1 element)
         * root.right = preorder[2:5] and inorder[2:5] (3 elements)
         */

        return root;

    }

}
