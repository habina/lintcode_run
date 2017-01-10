package com.google.phone;

public class BestTimeTpBuyAndSellStockII {
    
    public static int maxProfit(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(a));
        int[] b = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(b));
    }

}
