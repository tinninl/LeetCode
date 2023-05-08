/**
 * 309
 * 
 * unlimited transactions, must sell before buying again
 * cannot sell the next day
 */

public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * try drawing a decision tree
     * at any point, our choices are to buy/sell or cooldown (do nothing)
     * time complexity: for every day, we have 2 choices, so for n days,
     * it is 2^n
     * can we apply caching to store results?
     * we would want to know the day (index) and whether we bought or sold,
     * which can be represented by a boolean
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];
        
    }

   

    
}
