/*
 * Problem: 3573. Best Time to Buy and Sell Stock V
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long maximumProfit(int[] prices, int k) {
        long[] max = new long[k + 1];
        long[] min = new long[k + 1];
        long[] DP = new long[k + 1];
        long[] DPNext = new long[k + 1];
        Arrays.fill(max, Long.MIN_VALUE / 2);
        Arrays.fill(min, Long.MIN_VALUE / 2);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                DPNext[j] = Math.max(Math.max(max[j] - prices[i], min[j] + prices[i]), DP[j]);
                max[j] = Math.max(DP[j - 1] + prices[i], max[j]);
                min[j] = Math.max(DP[j - 1] - prices[i], min[j]);
            }
            long[] temp = DP;
            DP = DPNext;
            DPNext = temp;
        }
        return DP[k];
    }
}
