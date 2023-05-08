import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * nums can have duplicates
 * each element can only be used once
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        Arrays.sort(candidates);

        int start = 0;
        backtrack(result, combination, candidates, target, start);
        return result;
    }

    private void backtrack(
        List<List<Integer>> res,
        List<Integer> combination,
        int[] nums,
        int remainder,
        int start
    ){

        if (remainder < 0)
            return;
        
        if (remainder == 0){
            res.add(new ArrayList<>(combination));
        }

        else{
            for (int i = start; i < nums.length; i++){

                if (i > start && nums[i] == nums[i-1])
                    continue;

                combination.add(nums[i]);
                backtrack(res, combination, nums, remainder - nums[i], i + 1);
                combination.remove(combination.size() - 1);
            }
        }

    }

}
