package com.google.phone;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // buy[i] stands for maxProfit on day i when buy or not buy
        // sell[i] stands for maxProfit on day i when sell or not sell
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        // buy on day 0, loss profit for prices[0]
        buy[0] = -prices[0];
        // max on buy on day 0, or day 1
        buy[1] = Math.max(-prices[0], -prices[1]);
        // can't sell on day 0, thus profit is 0
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < prices.length; i++) {
            // either take buy[i-1] profit, the pre-day profit, not buy anything today
            // or take two days ago sell[i-2] profit - prices[i] (today buy cost), i - 2 is for cool down 1 day
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            // not sell, take sell[i-1]
            // sell, take buy[i-1] cost + prices[i] new price
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 0, 2 };
        System.out.println(maxProfit(a));
        int[] b = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(b));
    }

}
