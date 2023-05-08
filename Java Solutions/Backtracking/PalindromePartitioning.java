import java.util.ArrayList;
import java.util.List;
/**
 * Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.
 */

class PalindromePartitioning {
    
    public List<List<String>> partition(String s){

        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        int start = 0;

        backtrack(result, partition, s, start);

        return result;

    }

    private void backtrack(
        List<List<String>> res, 
        List<String> partition,
        String s,
        int start
    ) {

        if (start == s.length())
            res.add(new ArrayList<>(partition));

        for (int i = start; i < s.length(); i++) {

            String substring = s.substring(start, i + 1);

            if (!(isValidPalindrome(substring))) {
                continue;
            }

            partition.add(substring);
            backtrack(res, partition, s, i + 1);
            partition.remove(partition.size() - 1);
        }

    }

    private boolean isValidPalindrome(String s){

        int left = 0, right = s.length() - 1;

        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;

    }
}
