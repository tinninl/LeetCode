import java.util.Arrays;

/**
 * 567. Medium
 * 
 * Does s2 contain s1?
 * 
 * 2P, sliding window
 * 
 * all lowercase letters
 * 
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */

public class PermutationInString {
    
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (n > m)
            return false;

        //int left = 0, right = n - 1; // start and end of substring

        int store1[] = new int[26];
        int store2[] = new int[26];

        for (int i = 0; i < s1.length(); i++){
            store1[s1.charAt(i) - 'a']++;
        }  

        for (int i = 0; i < m; i++){

            store2[s2.charAt(i) - 'a']++;

            if (i >= n)
                store2[s2.charAt(i - n) - 'a']--;

            if (Arrays.equals(store1,store2))
                return true;

        }

        return false;
        
    }

}
