// Return a reference to the same node in the cloned tree.
// Target is guaranteed to be in the original tree
public class FindCorrespondingNode {
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        // Base case: original tree is null
        if (original == null)
            return null;
        
        if (original == target)
            return cloned;

        TreeNode res = getTargetCopy(original.left, cloned.left, target);

        if (res != null)
            return res;

        return getTargetCopy(original.right, cloned.right, target);

       
    }
}
