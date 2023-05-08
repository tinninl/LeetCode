import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    /**
     * Intuition: Suppose we traverse the array, checking each element n.
     * 
     * What questions can we ask about n?
     * 1. Is n the beginning of a new subsequence?
     * 2. Is n the end of a subsequence?
     * 
     * How do we know if n is the start of a new subsequence?
     * Ans. If n-1 doesn't exist in the array
     * 
     * How do we know if n is the end of a subsequence?
     * Ans. If n+1 doesn't exist in the array
     * 
     * It seems like we need some way to check if elements exist in the array.
     * How can we keep track of each unique element in the array?
     * We can use a hashset!
     * 
     * Our solution will look like this:
     * 
     * Set up a hashset.
     * 
     * Traverse the array. 
     * For each element n,
     * calculate the length of the subsequence ONLY IF
     * n is the START of a new subsequence. 
     * 
     * If we find the length of subsequence A which starts at 1, 
     * do we need to find the length of subsequence B which starts at 2?
     * No, because B will always be shorter than A
     * 
     * 
     */
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) 
            return 0;

        // Initialize our hashset to store each unique element in nums array
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);

        int maxLength = 1;  // the length of the longest subsequence

        for (int n: nums){

            // Is n is the beginning of a new subsequence?
            if (!set.contains(n - 1)){

                int length = 1;

                // If so, find the length of the subsequence
                while (set.contains(n + 1)){ 
                    n++;
                    length++;
                }

                // Update maxLength
                maxLength = Math.max(maxLength, length);

            }
            
            // What does this line of code mean?
            /* 
             * suppose length = 10
             * if we found a subequence of length 6, then that must be the longest
             * because the second longest can only be length 4.
             * so we can stop searching 
             */
            if (maxLength > nums.length / 2) 
                break;

        }

        return maxLength;
        
    }

}
