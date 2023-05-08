public class PalindromicSubstrings {
    
    public int countSubstrings(String s){

        int n = s.length();

        // Base cases: empty string or just one character
        if (n < 2)
            return n;

        int count = 0;
        int left, right;

        for (int i = 0; i < n; i++){

            // Each single character counts as a palindrome
            count ++;

            // odd length palindromes
            left = i - 1;
            right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }

            // even length palindromes
            left = i;
            right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }

        }

        return count;

    }

}
