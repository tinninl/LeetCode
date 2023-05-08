/**
 * 3 4 5 1 2 
 * 
 * output = 1, array was rotated 3 times to the left
 * guaranteed solution, unique elements
 */

public class FindMinimumInRotatedSortedArray {
    
    public int findMin(int[] nums){

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        int left = 0, right = nums.length - 1;

        int mid = 0;

        while (left <= right){

            // If the array wasnt rotated at all, then the leftmost element is the minimum
            if (nums[left] < nums[right])
                return nums[left];

            mid = (left + right) / 2;

            // Left sorted
            if (nums[mid] >= nums[left])
                left = mid + 1;

            // Right sorted
            else {
                right = mid;
            }

        }
        return nums[left];
    }

}
