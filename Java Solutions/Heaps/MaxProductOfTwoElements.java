import java.util.PriorityQueue;

/**
 * Given the array of integers nums, 
 * you will choose two different indices i and j of that array. 
 * Return the maximum value of (nums[i]-1)*(nums[j]-1).
 * what is the - 1 for???
 */
public class MaxProductOfTwoElements {

    /**
     * Sort the array
     * 
     */
    public int maxProduct(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(-nums[i]);
        }
        int max1 = -pq.poll();
        int max2 = -pq.poll();
        int result = (max1 - 1) * (max2 - 1);

        return result;
    }
}
