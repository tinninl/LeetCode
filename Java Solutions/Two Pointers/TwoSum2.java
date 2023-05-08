/**
 * 167. Two Sum 2 - Input Array is Sorted
 *  
 * Example:
 * 
 * Input: {2 7 11 15}
 * Target = 9
 * Output: {1 2}
 * return indices, (one indexed)
 * 
 * guaranteed unique solution, cant use same element twice
 * 
 * How might we change this solution if the solution is NOT guaranteed?
 * maybe res stores [-1,-1] by default, 
 * and we can change the else stmnt
 */
public class TwoSum2 {
    
    /*
     * Two pointers approach
     */
    public int[] twoSum2(int[] nums, int target){

        int[] res = new int[2];

        int left = 0, right = nums.length - 1;

        int sum;

        while (left < right){

            sum = nums[right] + nums[left];

            if (sum > target)
                right--;

            else if (sum < target)
                left++;

            else // (sum = target)
                break;           

        }

        // Remember: The array is 1-indexed,
        // so we must add one to left and right
        res[0] = left + 1;
        res[1] = right + 1;

        return res;

    }

}
