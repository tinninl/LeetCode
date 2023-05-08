public class MissingNumber {
    
    public int missingNumber(int[] nums){

        int n = nums.length;

        // What is the sum of 0 - n? (or 1 - n)
        int total =  n * (n + 1) / 2;

        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += nums[i];

        return total - sum;

    }
}
