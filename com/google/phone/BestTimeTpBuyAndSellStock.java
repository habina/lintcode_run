package com.google.phone;

public class BestTimeTpBuyAndSellStock {
    
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        // dp[i] stands for max profit on day i
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(a));
        int[] b = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(b));
    }

}
