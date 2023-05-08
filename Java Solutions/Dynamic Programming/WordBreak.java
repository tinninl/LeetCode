import java.util.List;

// s is not empty
// all lowercase
public class WordBreak {
    
    public boolean wordBreak(String s, List<String> wordDict){

        if (wordDict == null) 
            return false;

        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = dp.length - 1; i >= 0; i--){

            for (String word : wordDict){
                
                if ((i + word.length()) <= n && s.startsWith(word,i))
                    dp[i] = dp[i + word.length()];

                if (dp[i] == true)
                    break;

            }
        }

        return dp[0];
    }

}
