def maxProfit(self, prices: list[int]) -> int:

    buy = 0
    sell = 1
    maxProfit = 0
    
    while (sell < len(prices)):
        
        if (prices[sell] > prices[buy]):
            profit = prices[sell] - prices[buy]
            maxProfit = max(profit, maxProfit)
            
        else:
            buy = sell
            
        sell += 1
        
    return maxProfit