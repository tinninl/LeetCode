import java.util.HashSet;

/**
 * 424. Medium
 * 
 * Sliding Window
 * 
 * You are given a string s in UPPERCASE and an integer k. 
 * You can choose any character of the string 
 * and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter 
 * you can get after performing the above operations.
 */


public class LongestRepeatingCharacterReplacement {

    /**
     * In our window, we need to track each unique character
     * Our window can have up to k+1 distinct elements
     * Once our charSet has a size of k+2, we need to do some ops
     */

    public int characterReplacement(String s, int k){

        int start = 0, end = 0;

        int maxLength = 0;
        int maxFreq = 0;

        int[] count = new int[26];

        for (; end < s.length(); end++) {

            count[s.charAt(end) - 'A']++;

            maxFreq = Math.max(maxFreq, count[s.charAt(end) - 'A']);

            /**
             * if k = 2 and the most frequent element occurs 4 time(s), then our window
             * can have up to 2 + 4 = 6 elements
             */
            if (end - start + 1 > maxFreq + k){
                count[s.charAt(start) - 'a']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);

        }

        return maxLength;

    }
    
}
