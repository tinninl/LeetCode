import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * 
 * Monotonic Decreasing Queue problem
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */

public class SlidingWindowMaximum {

    /**
     * Whats the Brute Force approach?
     * Scan every single window and find the maximum.
     * But this takes a lot of repeated work
     * 
     * The time complexity is k windows times n-k slides
     * O(k * (n - k))
     */
 

    /**
     * Keep track of
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];

        int index = 0;

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            if (!q.isEmpty() && q.peekFirst() < i - k + 1) 
                q.pollFirst();

            // Is the current element greater than the max value so far?
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) 
                q.pollLast();

            q.offer(i);

            // If k = 3, only start adding elements to our result when i >= 3
            if (i >= k - 1) 
                ans[index++] = nums[q.peekFirst()];

        }

        return ans;
    }
}
