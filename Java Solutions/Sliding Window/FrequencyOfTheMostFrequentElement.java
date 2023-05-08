import java.util.Arrays;

/**
 * You can sort the array
 * 
 * The frequency of an element is the number of times it occurs in an array.
 * You are given an integer array nums and an integer k. 
 * In one operation, you can choose an index of nums and increment the element at that index by 1.
 * Return the maximum possible frequency of an element after performing at most k operations.
 * 
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * We can increment 1 three times
 */

public class FrequencyOfTheMostFrequentElement {
    
    /**
     * Suppose we check 8. Our window length is 3.
     * The goal would be to make all elements 8 (since we can't decrement value)
     * In order words, can we make a total of 8 times 3 elements (24)?
     * We already know the sum (1 + 4 + 8 = 13) and we have 5 to work with
     * 5 + 13 = 18, so at best we could make two elements equal to 8
     * 
     * So what do we need?
     * We need to track the start and end of the window, as well as its length
     * We need to track the sum of the window AND the target product
     * 
     */
    public int maxFrequency(int[] nums, int k) {

        int maxFreq = 0;            // the longest window we can make
        int sum = 0;                // the sum of elements in our window
        int left = 0, right = 0;    // the start and end of the window
        int winLen = 0;             

        Arrays.sort(nums);

        while (right < nums.length) {

            sum += nums[right];
            winLen++;
            
            // When we can longer reach our target product
            // We need to delete elements from the window
            while (nums[right] * winLen > sum + k){
                sum -= nums[left];
                left++;
                winLen--;
            }

            maxFreq = Math.max(maxFreq,winLen);

            right++;

        }

        return maxFreq;

    }
    
}
