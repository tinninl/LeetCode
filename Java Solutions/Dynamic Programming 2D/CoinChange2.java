public class CoinChange2 {

    public int change(int[] coins, int amount){

        int n = coins.length;

        if (n == 0 || amount == 0)
            return 0;

        int[] dp = new int [amount + 1]; 

        dp[0] = 1; // there is one combination to reach 0, [];

        for (int coin : coins){
            for (int i = 1; i <= amount; i++){
                if (coin <= i){
                    dp[i] += dp[i - coin];
                }
            }
        }
  
        return dp[amount];
    }

}
