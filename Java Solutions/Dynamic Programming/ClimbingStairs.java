/**
 * 70. Climbing Stairs
 * 
 * Memoization and DP
 * 
 * You are climbing a staircase. 
 * It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * 
 *  1 <= n <= 45
 */

public class ClimbingStairs {

    /**
     * Try drawing a decision tree. 
     * At every point, we can take 1 or 2 steps
     * 
     * Notice that parts of the tree are the exact same,
     * meaning that we are doing repeated work
     * 
     * We need to save our answers in a cache of some sort
     * We want to solve each subproblem only once
     * 
     * We see that each subproblem depends on the next subproblem
     * So we should use a bottom up approach, start from n instead of 0
     * @param n
     * @return
     */

    /**
     * Bottom up approach (memoization)
     */
    public int climbStairs(int n){

        if (n <= 2)
            return n;

        int[] cache = new int[n + 1];

        // If we are on step n, we don't need to take any more steps
        cache[n] = 1; // the goal

        // If we are on step 99, and our goal is 100
        // then we only have one path to take (one step)
        cache[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--){
            cache[i] = cache[i + 1] + cache[i + 2];
        }

        // cache[0] represents the distant paths to step n from step 0
        return cache[0];

    }

    /**
     * We note that this problem is exactly like the fibonacci sequence
     * it starts from 1 and 1, rather than 0 and 1
     */
    public int climbStairs2(int n){

        if (n <= 1)
            return n;

        int first = 1;
        int second = 1;
        int temp;

        for (int i = 2; i <= n; i++){
            temp = first + second;
            first = second;
            second = temp;
        }

        return second;
    } 

}
