import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, 
 * return the k most frequent elements. You may return the answer in any order.
 * Can we sort the array?

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */

public class TopKFrequentElements {

    /**
     * How can we keep track of the count of each number?
     * We can use a map with key value pairs
     * Key = number
     * Value = the count of the number
     * 
     * Example: [5 5 5 5  6 6 6 7 7 8]
     * 
     * Our map would look like this:
     * 
     * 5 : 4
     * 6 : 3
     * 7 : 2
     * 8 : 1
     * 
     */
    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];

        HashMap<Integer,Integer> map = new HashMap<>(nums.length);

        // Put the elements in nums into the hashmap
        for (int i = 0; i < nums.length; i++) {

            // If its a new element, put 1
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            // If it already exists, add 1
            else{
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
       

        return res;
    }

    /**
     * How do we grab the top k elements from the map and put it into our resultant array?
     * Way easier to do this in python
     */

    
}
