public class MinCostClimbingStairs {

    /**
     * Try a similar bottom up approach
     * @param cost
     * @return
     */

    /**
     * n is the top floor, the goal (outside the array)
     * If we start at n-1, it will cost cost[n-1] to reach the top
     * If we start at n-2, it will cost cost[n-2] to reach the top
     * 
     * modify cost[] so that it represents the total cost to reach n from index i
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost){

        int n = cost.length;

        if (n == 0) return 0;
        if (n == 1) return cost[0];

        for (int i = n - 1; i >= 0; i--)
            cost[i] += Math.min(cost[i + 1], cost[i + 2]); 
            
        // Cost[i] represents the minimum cost it will take to reach floor n
        // from floor i

        // Is it cheaper to start from floor 0 or floor 1?
        return Math.min(cost[0],cost[1]);
        
    }

}
