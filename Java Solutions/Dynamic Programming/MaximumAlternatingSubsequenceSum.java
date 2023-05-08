/**
 * 
 * 1911. dp
 * sum of even indices - sum of odd indices
 * 
 * how to build subsequence:
 * as long as the elements are in RELATIVE order, its good
 * 
 * [1 2 3 4 5 6] 
 * [2 4 5] is a valid subsequence
 * 
 * Example:
 * Input: nums = [6,2,1,2,4,5]
 * Output: 10
 * Explanation: It is optimal to choose the subsequence [6,1,5] 
 * with alternating sum (6 + 5) - 1 = 10.
 * 
 *  only positive numbers 
 * 
 * 0 indexed
 */

public class MaximumAlternatingSubsequenceSum {
    
    public long maxAlternatingSum(int[] nums){

        int n = nums.length;

        // Base cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int sum = 0;
        for (int num : nums) 
            sum += num;

    

        int i = 1;

        if (nums[i] > nums[i + 1])
            // add to sub

        
    }
}
