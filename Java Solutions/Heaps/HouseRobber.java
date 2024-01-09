/**
 * 198. House Robber
 * Medium
 * 
 * Tags: Dynamic Programming
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them 
 * is that adjacent houses have security systems connected 
 * and it will automatically contact the police if 
 * two adjacent houses were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house, 
 * return the maximum amount of money you can rob tonight without alerting the police
 * 
 * Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */

 public class HouseRobber {

    public int rob(int[] houses) {

        int rob1 = 0, rob2 = 0;

        int temp = 0;
        
        // [rob1, rob2, n, n+1, n+2...]
        for (int i = 0; i < houses.length; i++){
            
            temp = Math.max(houses[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;

        }

        return rob2;

    }
    
}
