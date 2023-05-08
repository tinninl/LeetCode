/**
 * [1 5 11 5]
 * true 
 */

public class PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums){

        int sum = 0;

        for (int num : nums) 
            sum += num;
        
        // If the sum is odd, then we can't partition it equally in half
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        // dp[i] = can we create a subset that sums up to i?
        boolean[] dp = new boolean[target + 1];

        // We can always have a subset that sums to 0, the empty subset []
        dp[0] = true;

        for (int n : nums)

            for (int i = target; i >= n; i--)
                /**
                 * if target (i) = 6, and n = 5
                 * is there a subset that sums up to i - n (1)?
                 */
                if (dp[i - n] == true) 
                    dp[i] = true;

        // The last index is dp[target]
        return dp[dp.length - 1];

    }
    
}
