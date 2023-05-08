import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams
 * 
 * Medium
 * 
 * Given an array of string strs, group the anagrams together. 
 * You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: strs = eat, tea, tan, ate, nat, bat
 * Output: [bat], [nat, tan], [ate, eat, tea]
 * 
 * Try solving ValidAnagram first
 */
public class GroupAnagrams {

   
    /**
     * Similar to ValidAnagram, we should keep a store of letters for each word
     * For example, eat has 1E 1A and 1T. 
     * We want to find other words with the same "store" of letters
     * 
     * We can use a map! 
     * The key can be the 'store' of letters, 
     * and the values can be the words with those stores
     * 
     * How can we create a store? (In python this would easier) 
     * In Java, we can use an int array[26] and convert it to a string
     * Easier way, make a char array and sort it, convert it back into a string
     * 
     * We can check each string, create a store, and either create a new entry in the map,
     * or just put it in there if it already exists
     * 
     * Once we are finished building the map, just group the values together in
     * a list
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0)
            return null;

        List<List<String>> res = new ArrayList<>();
        
        // key = count of characters(array), value = list of strings (mini results)
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String word: strs) {

            // Initialize a store of letters for each string
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String store = new String(arr);

            // If the store doesn't exist, create a new map entry
            if (!map.containsKey(store))
                map.put(store, new ArrayList<String>());
            
            // Match the word with the store
            map.get(store).add(word);

        }

        // Add the arraylists (values) from the map into our result
        for (String word : map.keySet()){
            res.add(map.get(word));
        }

        return res;
    }
}
