/*
 * Problem: 309. Best Time to Buy and Sell Stock with Cooldown
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int maxProfit(int[] prices) {
        int delay = 0;
        int res = 0;
        int max = Integer.MIN_VALUE;
        int available = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(max + prices[i], res);
            max = Math.max(available - prices[i], max);
            available = delay;
            delay = res;
        }
        return res;
    }
}
