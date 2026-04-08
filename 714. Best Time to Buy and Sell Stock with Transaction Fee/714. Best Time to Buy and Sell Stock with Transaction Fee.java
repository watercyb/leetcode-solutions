/*
 * Problem: 714. Best Time to Buy and Sell Stock with Transaction Fee
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(res - prices[i], max);
            res = Math.max(max + prices[i] - fee, res);
        }
        return res;
    }
}
