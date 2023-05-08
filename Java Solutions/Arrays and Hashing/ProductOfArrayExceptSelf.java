/**
 * 238. Medium
 * Given an integer array nums, return an array answer such that answer[i] is equal 
 * to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2: 
Input [-1, 1, 0, -3, 3]
Output [0, 0, 9, 0 0]
 */

public class ProductOfArrayExceptSelf {
    
    /*
     * Create two arrays, prefix and postfix, 
     * to represent the products before and after the index
     * 
     * pre = [1 1 2 6]
     * post = [24 12 4 1]
     * 
     * This solution is O(n) because you do three passes to build 3 arrays
     * 
     * Can we do this faster by only modifying the original array?
     * probably, but this way is easier to read and im lazy
     */
    public static int[] productExceptSelf(int[] nums) {
     
        int n = nums.length;

        int[] res = new int[n];
        int[] pre = new int[n];     // prefixes
        int[] post = new int[n];    // postfixes

        // Initialize the prefixes array
        pre[0] = 1;
        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] * nums[i - 1];

        // Initialize the postfixes array
        post[n-1] = 1;
        for (int i = n - 2; i >= 0; i--)
            post[i] = post[i + 1] * nums[i + 1];    
            
        /**
         * Note: What should the first index of the prefix array and 
         * the last index of the postfix array be?
         * Intuition: Just let be them 1's.
         */
        
        /**
         * Build the resultant array,
         * where res[i] = pre[i] * post[i]
         */
        for (int i = 0; i < n; i++)
            res[i] = pre[i] * post[i];

        // If you want to print out the arrays, uncomment this block
        /* 
        for (int i = 0; i < n; i++)
            System.out.println("prefix[" + i + "] = " + pre[i]);         
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.println("postfix[" + i + "] = " + post[i]);
        System.out.println();    
        for (int i = 0; i < n; i++)
            System.out.println("result[" + i + "] = " + res[i]);
        System.out.println();   
        */
        
        return res;

    }

    public static void main(String[] args) {
       int[] x = {-1, 1, 0, -3, 3};
       //int[] x = {1,2,3,4};
        productExceptSelf(x);
    }
    
}
