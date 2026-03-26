/*
 * Problem: 188. Best Time to Buy and Sell Stock IV
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] DP = new int[prices.length][k + 1];
        for (int i = 1; i <= k; i++) {
            int tmp = DP[0][i - 1] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                DP[j][i] = Math.max(tmp + prices[j], DP[j-1][i]);
                tmp = Math.max(DP[j][i - 1] - prices[j], tmp);
            }
        }
        return DP[prices.length - 1][k];
    }
}
