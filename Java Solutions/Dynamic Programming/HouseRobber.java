/**
 * cant rob adjacent houses
 * return max money
 */

public class HouseRobber {
    
    public int rob(int[] nums){

        int rob = 0, pass = 0, max = 0;

        // Two choices: rob or pass the house
        // If we rob, we get the money and the money we had when we passed the last house
        // If we pass, we get the money we robbed from the last house

        if (nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        for (int i = 0; i < nums.length; i++){
            
            rob = nums[i] + pass;
            pass = max;
            max = Math.max(rob, pass);
            
        }

        return max;

    }
}
