public class DecodeWays {

    // bottom up
    public int numDecodings(String s){

        int n = s.length();

        int[] dp = new int[n + 1];

        dp[0] = 1; // there is one way to decode an empty string

        // Edge case: 0 is the first character
        if (s.charAt(0) == '0')
            dp[1] = 0;        
        else
            dp[1] = 1;

        for (int i = 2; i < n + 1; i++){

            // take it as a single digit character
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }

            // take it a double digit character
            if (
                (s.charAt(i - 2) == '1') || // 10 through 19
                (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')// 20 through 26
            ){
                dp[i] += dp[i - 2];
            }

            
        }

        return dp[n];
    }
}
