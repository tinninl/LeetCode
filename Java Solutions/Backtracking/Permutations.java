import java.util.ArrayList;
import java.util.List;

/**
 *Given an array nums of distinct integers, 
 return all the possible permutations. 
 You can return the answer in any order.

 For an array of size n, there are n! permutations
 */

public class Permutations {
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> permutation = new ArrayList<Integer>();

        backtrack(result, permutation, nums);

        return result;

    }

    private void backtrack(List<List<Integer>> res, List<Integer> permutation, int[] nums){

        // We found a permutation, add it to the result
        if (permutation.size() == nums.length)
            res.add(new ArrayList<>(permutation));
                
        else {

            for (int i = 0; i < nums.length; i++){

                // Element already exists in the permutation
                if (permutation.contains(nums[i]))
                    continue;

                // Two choices, either add the element, or skip it
                permutation.add(nums[i]);
                backtrack(res, permutation, nums);
                permutation.remove(permutation.size() - 1);

            }
        }
    }
}
