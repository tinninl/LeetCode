import java.util.HashSet;
import java.util.Set;

/**
 * 219. easy sliding window
 * Given an integer array nums and an integer k, 
 * return true if there are two distinct indices i and j in the array 
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 * 
 * Are there any duplicates close to one another?
 */

public class ContainsDuplicatesTwo {
    
    /**
     * We need to track k elements at any given time
     * We can use a hashset of size k
     * 
     * As we traverse the array, if n already exists in the window,
     * we found a nearby dup
     * 
     * If our window is full, we must delete the FIRST element
     * and update our left pointer
     */
    public boolean containsNearbyDuplicte(int[] nums, int k){

        int left = 0;
        int right = 0;

        Set<Integer> window = new HashSet<Integer>();
        
        for (; right < nums.length; right++) {
            
            // Is our window full? If so, delete the first element in the set
            if (window.size() > k){
                window.remove(nums[left]);
                left++;
            }

            if (window.contains(nums[right]))
                return true;

            window.add(nums[right]);
    
        }
 
        return false;

    }
    
}
