/**
 * 0 1 true false leaf nodes
 * 2 or 3 and non leaf nodes
 * guaranteed 0 or 2 children on each node
 */
public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {
        
        switch (root.val) {

            case 0:
                return false;
            
            case 1:
                return true;

            case 2: // 2 = OR
                return evaluateTree(root.left) || evaluateTree(root.right);

            case 3: // 3 = AND
                return evaluateTree(root.left) && evaluateTree(root.right);

            // code should never reach here
            default:
                return false;

        }      

    }

}
