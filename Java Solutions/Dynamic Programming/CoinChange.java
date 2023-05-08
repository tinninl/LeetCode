import java.util.Arrays;

public class CoinChange {

    /**
     * bottom up approach
     * 
     * how many coins do we need to make 0?
     * to make 1?
     * ...
     * to make n-1?
     * to make n?
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        if (coins.length == 0 || amount == 0) 
            return 0;

        int[] dp = new int[amount + 1];

        // if our target is 7, then we fill the array with 8
        // which is impossible
        Arrays.fill(dp, amount + 1);

        // It takes 0 coins to reach a total of 0
        dp[0] = 0;
        
        // Fill each index of dp
        // i is the amount we want to reach
        // index = target 
        for (int target = 1; target < dp.length; target++) 

            // Check all the coins
            for (int coin : coins)  

                if (target - coin >= 0)
                    dp[target] = Math.min(dp[target], 1 + dp[target - coin]);           

        if (dp[amount] != amount + 1)
            return dp[amount];

        else 
            return -1;
    }
}
