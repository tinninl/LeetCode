import java.util.HashMap;

/**
 * 1. Two Sum
 * Easy
 * 
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Assume nums always has at least 2 elements

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 */
public class TwoSum {
    
    /*
     * Solution: nested for loop
     */
    public int[] twoSum1(int[] nums, int target){

        int[] result = new int[2];
        
        // Base case, just return -1 to show errors
        if (nums.length < 2){
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        for (int i = 0; i < nums.length; i++){

            for (int j = i+1; j < nums.length; j++){

                if (nums[i] + nums[j] == target){

                    result[0] = i;
                    result[1] = j;
                    
                }
            }
        }

        return result;
    }

    /*
     * Solution 2: Use a hashmap, O(n)
     * Traverse array, put key value pairs into the map (key = element, value = index)
     * Check if there exists an element in the Hashmap such that
     */
    public int[] twoSum2(int[] nums, int target){

        int[] result = new int[2];

        HashMap<Integer,Integer> seen = new HashMap<>();
        
        // Base case
        if (nums.length < 2){
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        // Traverse the array
        for (int i = 0; i < nums.length; i++){
            
            // Does nums[i], the current element, 
            // add up with anything in the hashmap to equal target?
            // If yes, return value and nums[i]
            if (seen.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = seen.get(target - nums[i]);
                break;
            }

            // Add the value and index to the hashmap
            seen.put(nums[i], i);

        }

        return result;

    }

}