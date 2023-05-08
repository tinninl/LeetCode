import java.util.HashMap;

public class TargetSum {

    /**
     * Backtracking BF approach
     * 
     * Draw a decision tree, with two choices, to add or subtract the element
     * Once we check every element, did we sum up to target?
     * 
     * Base cases: We have checked every element
     * Now we check if our sum is equal to target
     * 
     * We need to keep track of the index and the current sum
     * 
     */

    // key = sum, value = index
    HashMap<Integer, Integer> map;

    public int findTargetSumWays(int[] nums, int target) {

        map = new HashMap<Integer, Integer>();
        int sum = 0;
        int index = 0;
        return dfs(nums, target, sum, index);
    }


    private int dfs(int[] nums, int target, int sum, int index){

        if (map.containsKey(sum))
            return map.get(sum);

        // How many ways are there to sum up to target?
        int ways = 0;

        // If we processed every element, we are done
        if (index == nums.length){
            if (target == sum) 
                return 1;
            else 
                return 0;
        }

        // Two choices, to add to or subtract from sum
        ways += dfs(nums, target, sum + nums[index], index + 1);
        ways += dfs(nums, target, sum - nums[index], index + 1);

        map.put(sum, index);
        
        return ways;
    }

}
