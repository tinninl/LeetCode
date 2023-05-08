public class LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums){

        int n = nums.length;

        if (n <= 1)
            return n;

        int[] LIS = new int[n];

        // Arrays.fill(LIS, 1);
        for (int i = 0; i < n; i++)
            LIS[i] = 1;
        
        int maxLength = 1;

        for (int i = n - 1; i >= 0; i--){

            for (int j = i + 1; j < n; j++)

                if (nums[i] < nums[j])
                    LIS[i] = Math.max(1 + LIS[j], LIS[i]);                           

            if (LIS[i] > maxLength)
                maxLength = LIS[i];

        }

        return maxLength;

    }

}
