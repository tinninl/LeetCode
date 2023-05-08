public class LongestPalindromicSubstring {
    
    public String longestPalindrome(String s){

        int n = s.length();

        if (n < 2)
            return s;

        int left, right;

        int start = 0, end = n - 1; // start and end indices of the longest substring

        int length = 0; // length of palindrome
        int maxLength = 0; // length of longest palindrome

        for (int i = 0; i < n; i++){

            // odd length palindromes
            left = i - 1;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            length = right - left - 1;

            if (length > maxLength) {
                maxLength = length;
                start = left + 1;
                end = right - 1;
            } 

            // even length palindromes
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            length = right - left - 1;

            if (length > maxLength) {
                maxLength = length;
                start = left + 1;
                end = right - 1;
            } 

        }
        return s.substring(start, end + 1);
    }

}
