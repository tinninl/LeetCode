public class KokoEatingBananas {
    
    /**
     * 
     * If koko eats 5 b/h, and there are 4 bananas, it will still take the entire hour
     * 
     * Intuition:
     * We want the slowest Koko can eat, but what is the fastest she can eat?
     * Its the maximum pile of bananas
     * Ex. [1 1 1 25]
     * The worst case would eating 25 bananas/h
     * 
     * And the best case would be eating 1 banana an hour
     * 
     * So our search radius will be in between 1 to max(piles)
     */
    public int minEatingSpeed(int[] piles, int h) {

        /**
         * left, right, and mid represent Koko's eating speed in bananas per hour
         */
       
        int left = 1;

        int right = 1;

        for (int pile : piles)
            right = Math.max(right, pile);

 
        while (left <= right){

            int mid = (left + right) / 2;
            int time = 0;

            // Calculate the time it will take Koko to finish all banana piles at 
            // a speed of mid b/h
            for (int pile : piles){
                time += Math.ceil((double) pile / mid);
            }

            /**
             * How should we change our search parameters?
             * Why is it time <= h instead of time < h?
             * 
             * Suppose at a speed of 6, Koko meets the target hours exactly
             * But we aren't done yet, because we still need to check 5 
             * 
             * So we can't use right = mid - 1
             * We still need to include 5 in our search, so we use right = mid
             */
            if (time <= h){
                
                right = mid - 1;
            }
            else
                left = mid + 1;
        
        }
        return right;
    }

}
