import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that
 * every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        int m = s.length();
        int n = t.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int start = 0;
        int minLen = m + 1;

        int left = 0;
        int matched = 0;

        for (int right = 0; right < m; right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0){
                    matched++;
                }
            }

            while (matched == map.size()){
                int length = right - left + 1;
                if (length < minLen){
                    minLen = length;
                    start = left;
                }

                char deleted = s.charAt(left++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;

                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }

        if (minLen > m){
            return "";
        }
        else{
            return s.substring(start, start + minLen);
        }

        

    }

    public static void main(String[] args) {
        String s = "adobecodebanc";
        String t = "abc";
        String x = minWindow(s, t);
        // System.out.println(x);
    }

}
