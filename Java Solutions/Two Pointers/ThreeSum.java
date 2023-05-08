import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;


/**
 * 15. 3Sum
 * 
 * return triplets that add up to 0, you can sort the array
 * Example:
 * 
 * Input: [ -1 0 1 2 -1 4]
 * Output: [-1 -1 2], [-1 0 1]
 */
public class ThreeSum {

    /**
     * Intuition: This problem seems similar to the TwoSum 2 problem 
     * If the array is sorted, can we apply the solution from TwoSum 2?
     * 
     * We can traverse the array, checking every element n
     * Suppose n = 3, then we are looking for two numbers that sum to -3
     * We can apply the two pointer technique
     * Process all negative numbers, looking at the numbers on the right hand side
     * 
     * If we find a triplet, we can add it our solution
     * 
     * Note: There could be multiple solutions for n
     * And we need to check for duplicates
     * 
     * Example: [-5, 1, 1, 2, 3, 4, 4]
     * 
     */
    public List<List<Integer>> threeSum(int[] nums){

        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        ArrayList<Integer> miniRes;

        int left, right, target;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){

            // Skip duplicate values
            if ((i > 0) && (nums[i] == nums[i - 1]))
                continue;

            // Skip nonnegative values. Why?
            /**
             * Because there is no solution
             * Our 'search space' are the numbers on the rightside of n
             * So, if n = 0, we would be looking for two positive integers that sum to 0,
             * which is silly
             */
            if (nums[i] >= 0)
                continue;

            // Apply the solution from Two Sum 2 (Question 167)
            /**
             * Limit our search space to the numbers on the righthandside of n
             */
            target = 0 - nums[i];
            left = i + 1;
            right = nums.length - 1;

            while (left < right){

                int sum = nums[left] + nums[right];

                if (sum > target)
                    right--;

                else if (sum < target)
                    left++;
                
                else {  // (sum = target)

                    // Add the triplet to our result
                    // (Easier to do in python)
                    miniRes = new ArrayList<>(); 
                    miniRes.add(nums[i]);
                    miniRes.add(nums[left]);
                    miniRes.add(nums[right]);
                    res.add(miniRes);
                    
                    // Check for duplicate solutions
                    while ((left < right) && (nums[left] == nums[left + 1]))
                        left++;

                    while ((left < right) && (nums[right] == nums[right - 1]))
                        right--;
                    
                    left++;
                    right--;

                } 

            } 

        } 

        return res;
        
    }
   
}
