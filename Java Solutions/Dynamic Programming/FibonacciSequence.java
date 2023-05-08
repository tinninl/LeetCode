public class FibonacciSequence {
    
    public int fib(int n){

        if (n <= 1)
            return n;

        // We only need to keep track of the last 2 elements of the sequence
        int[] dp = new int[2];
        dp[0] = 0; // i - 2
        dp[1] = 1; // i - 1

        int temp;

        for (int i = 2; i <= n; i++){
            temp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = temp;
        }

        return dp[1];
    }
}
