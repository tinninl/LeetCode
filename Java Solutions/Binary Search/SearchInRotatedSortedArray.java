/**
 * 4567012
 * target = 0, return the index 4
 * was rotated 4 times to the left
 */


public class SearchInRotatedSortedArray {
    
    public int search(int[] nums, int target){

        int left = 0, right = nums.length - 1;

        int mid = 0;

        while (left <= right){

            mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;

            // Left sorted
            if (nums[left] <= nums[mid])

                if (target > nums[mid] || target < nums[left])
                    left = mid + 1;

                else 
                    right = mid - 1;

            // Right sorted
            else

                if (target < nums[mid] || target > nums[right])
                    right = mid - 1;

                else 
                    left = mid + 1;
            
        }
  
        return -1;

    }

}
