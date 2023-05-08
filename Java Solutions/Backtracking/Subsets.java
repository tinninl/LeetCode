import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. 
Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

// Hint: for an array of size n, there are 2 ^ n subsets
public class Subsets {

    // Brute force
    public List<List<Integer>> subset(int[] nums){
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> subset = new ArrayList<>();

        // Always add the empty subset to the result
        res.add(subset);

        // Keep building subsets until nothing can be built (its empty)
        subset.add(0);
        while (!subset.isEmpty()){

            // Build a new subset
            for (int i = 0; i < nums.length; i++) {

                subset = new ArrayList<>(); // Create a new subset

                // Is miniRes in res already?
                if (res.contains(subset)) {
                    // do nothing
                }

                else {
                    subset.add(nums[i]);
                }

            }

            res.add(subset);

        }

        return res;

    }

    public List<List<Integer>> subset2(int[] nums){
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int start = 0;
        backtrack(res, subset, nums, start);
        return res;
    }

    private void backtrack(
        List<List<Integer>> res, 
        List<Integer> subset, 
        int[] nums,
        int start
    ) {

        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++){

            subset.add(nums[i]);
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);

        }

    }
}
