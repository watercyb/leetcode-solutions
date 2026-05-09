/*
 * Problem: 3652. Best Time to Buy and Sell Stock using Strategy
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i] * strategy[i];
        }
        long res = sum;
        long diff = 0;
        for (int i = 0; i < k / 2; i++) {
            diff -= prices[i] * strategy[i];
        }
        for (int i = k / 2; i < k; i++) {
            diff += prices[i] * (1 - strategy[i]);
        }
        int l = 0;
        int mid = k / 2;
        int r = k;
        res = Math.max(sum + diff, res);
        while (r < prices.length) {
            diff += prices[r] * (1 - strategy[r]) - prices[mid] + prices[l] * strategy[l];
            res = Math.max(sum + diff, res);
            l++;
            mid++;
            r++;
        }
        return res;
    }
}
