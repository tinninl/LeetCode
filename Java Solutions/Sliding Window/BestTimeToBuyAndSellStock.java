/**
 * 121. Easy 
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and 
 * choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. 
 * If you cannot achieve any profit, return 0.
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Buy on day 2 and sell on day 5
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Intuition: We should keep track of two days (indices),
     * the day we buy and the day we well
     * 
     * We can start on days 1 and 2
     * 
     * If the buying price is greater than the selling price, 
     * then there is no profit and we shift both pointers
     * 
     * Otherwise, we calculate the profit and shift the sell pointer only
     * 
     */

    public int maxProfit(int[] prices) {

        if (prices.length < 2)
            return 0;

        int maxProfit = 0;

        int buy = 0, sell = 1;

        while (sell < prices.length){

            // Can a profit be made?
            if (prices[buy] < prices[sell]) {

                int profit = prices[sell] - prices[buy];

                maxProfit = Math.max(maxProfit, profit);

            } else {
                buy = sell;
            }

            sell++;  

        }

        return maxProfit;
     
    }
    
}