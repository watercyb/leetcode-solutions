/*
 * Problem: 122. Best Time to Buy and Sell Stock II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                res += prices[i]-prices[i-1];
        }
        return res;
    }
}
