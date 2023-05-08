public class MinSumMountainTriplets{

    public int minimumSum(int[] nums){

        int n = nums.length;

        if (n < 3){
            return -1;
        }

        int l = 0, r = nums.length - 1;

        int m1 = 0, m2 = 0;

        int sum1 = -1, sum2 = -1, minSum = Integer.MAX_VALUE;

        while (l < r){

            while (nums[l] > nums[l + 1]){
                l++;
            }

            while (nums[r] > nums[r - 1]){
                r--;
            }

            m1 = l + 1;
            m2 = r - 1;

            if (nums[m1] < nums[m2]){
                sum1 = nums[l] + nums[m1] + nums[r];
                l++;
            }
            
            else{
                sum1 = nums[l] + nums[m2] + nums[r];
                r--;
            }

            sum2 = sum1;
            if (sum1 < minSum)
                minSum = sum1;

        }

        return minSum;


    }

}