package com.facebook.phone;

public class BestTimeToBuyAndSellStock {
    
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int curBuy = Integer.MAX_VALUE;
        
        for (int price : prices) {
            curBuy = Math.min(price, curBuy);
            profit = Math.max(profit, price - curBuy);
        }
        
        return profit;
    }

}
