/**
 * 242. Valid Anagram
 * 
 * Easy
 * 
 * Given two strings s and t, return true if t is an anagram or s,
 * and false otherwise.
 * 
 * Assume lowercase characters
 */
public class ValidAnagram {
    
    public boolean isValidAnagram(String s, String t){

        // Are the two strings the same length? 
        if (s.length() != t.length())
            return false;

        
        /**
         * We want to store the number of each character in both strings
         * Let store1 track string s and store2 track string t
         * 
         * Ex. If store[0] = 3, that means there are 3 "a"s in string s 
         * 1 = b , 2 = c , 3 = d, etc
         */
        int[] store1 = new int[26];
        int[] store2 = new int[26];

        // read ascii tables
        for (int i = 0; i < s.length(); i++){
            store1[s.charAt(i) - 'a']++;
            store2[t.charAt(i) - 'a']++;
        }

        // If the two strings are anagrams, then the stores should be identical
        for (int i = 0; i < store1.length; i++)

            if (store1[i] != store2[i])
                return false;  

        return true;

    }
    
}
