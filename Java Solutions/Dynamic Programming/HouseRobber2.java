/**
 * This time, the houses are in a circle
 * 
 * so index 0 is connected to index n
 */

public class HouseRobber2 {

    public int rob(int[] nums){

        int n = nums.length;

        if (n == 0) return 0;

        if (n == 1) return nums[0];

        // We can pick two paths to rob the neighbourhood

        // If we rob starting from the first house (index 0), how much money?
        // We end at the second to last house (index n -2)
        int path1 = robHelper(nums, 0, n-2);

        // If we rob starting from the second house (index 1), how much money?
        // We end at the last house (index n - 1)
        int path2 = robHelper(nums, 1, n-1);

        // Which path gives the most money?
        return Math.max(path1, path2);

    }

    // Same solution from house robber 1
    private int robHelper(int[] nums, int start, int end){

        int rob = 0, pass = 0, max = 0;

        // its i <= end, since we include the ending house
        for (int i = start; i <= end; i++){

            rob = nums[i] + pass;
            pass = max;
            max = Math.max(rob, pass);  

        }

        return max;

    }


}
