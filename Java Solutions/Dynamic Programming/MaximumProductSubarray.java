public class MaximumProductSubarray {

    // Brute force approach, just try ALL subarrays
    // Are there any patterns we can see?

    // [2 3 -2 4]
    public int maxProduct(int[] nums) {

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int max = 1;
        int min = 1;
        int res = nums[0];

        for (int n : nums){

            if (max == 0){
                max = 1;
                min = 1;
            }

            int prod1 = max * n;
            int prod2 = min * n;

            max = Math.max(prod1, prod2);
            min = Math.min(prod1, prod2);

            res = Math.max(res, max);
        }

        return res;
        
    }
}
