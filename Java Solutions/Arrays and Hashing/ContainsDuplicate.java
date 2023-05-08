/*
 * 217. Contains Duplicate
 * 
 * Given an integer array nums, 
 * return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 */

import java.util.HashSet;
 
public class ContainsDuplicate {

    /**
     * Brute-force approach
     * We can sort the array first, then traverse the array,
     * checking if the neighbors are duplicates
     * 
     * Sorting is a O(n log n) 
     *
     * Can we do better? Can we get O(n)
     */
    
    
    /**
     * As we traverse the array,
     * we want to keep track of the elements we have already seen. How?
     * 
     * We can use a hashset and add elements to the set as we traverse the array!
     * 
     * As we continue to traverse, we can check if nums[i] is already in the hashset.
     * 
     * If it is, we found the duplicate element!
     *
     */
    public static boolean containsDuplicate(int[] nums){
 
        HashSet<Integer> uniques = new HashSet<>();

        for (int num: nums){

            // Does our hashset already contain num?
            if (uniques.contains(num))
                return true;           

            else 
                uniques.add(num);

            // Note: add num to the set AFTER checking if it contains num
            // What happens if we add, then check?

        }

        return false;
        
    }
    
}
