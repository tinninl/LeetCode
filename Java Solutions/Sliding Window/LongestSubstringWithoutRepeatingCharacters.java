import java.util.HashMap;
import java.util.HashSet;
/**
 * 3. Medium
 * 
 * hashmap, sliding window, array
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Traverse the string
     * We need to keep track of each unique character in our substring
     * Should we use a hashset or a hashmap?
     * 
     * Do we need to track the start and end of the substring?
     */

    public int lengthOfLongestSubstring(String s){

        int maxLength = 0;

        HashSet<Character> charSet = new HashSet<>();

        int left = 0, right = 0;

        for (; right < s.length(); right++) {

            char ch = s.charAt(right);

            while (charSet.contains(ch)) { 

                charSet.remove(s.charAt(left));
                left++;

            }

            charSet.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);

            // Note: calculating maxLength every time is expensive
            // and can probably be optimized
  
        }

        return maxLength;

        

    }


}
