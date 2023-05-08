/**
 * O log n, easy, return -1 if not found
 * Check the middle element 
 * If greater than target, search left
 * 
 * If less than target, search right
 */
public class BinarySearch {
    
    public int search(int[] nums, int target){

        int left = 0, right = nums.length - 1;
        
        int mid;

        while (left <= right){

            mid = (left + right) / 2;

            if (target < nums[mid])
                right = mid - 1;
            
            else if (target > nums[mid])
                left = mid + 1;

            else
                return nums[mid];

        }

        return -1;

    }

}
