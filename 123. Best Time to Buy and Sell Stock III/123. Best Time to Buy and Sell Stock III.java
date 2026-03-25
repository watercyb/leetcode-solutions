/*
 * Problem: 123. Best Time to Buy and Sell Stock III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int maxProfit(int[] prices) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        int[] price = new int[prices.length];
        int miaPrice = 0;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                max = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
                miaPrice = Math.max(max - min, miaPrice);
            }
            price[i] = miaPrice;
        }
        max = -1;
        min = Integer.MAX_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (max < prices[i]) {
                min = prices[i];
                max = prices[i];
            }
            if (min > prices[i]) {
                min = prices[i];
                res = Math.max(max - min + price[i], res);
            }
        }
        return res;
    }
}
