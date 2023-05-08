import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets but contains duplicates
 * Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class Subsets2 {
    
    // O(n * 2^n)
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        int start = 0;

        Arrays.sort(nums);

        backtrack(result, subset, nums, start);

        return result;
        
    }

    private static void backtrack(
        List<List<Integer>> res,
        List<Integer> subset,
        int[] nums,
        int start
    ){

        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++){

            // Skip duplicate elements
            if (i > start && nums[i] == nums[i-1])
                continue;

            subset.add(nums[i]);
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};

        System.out.println(subsetsWithDup(nums));

    }

}
