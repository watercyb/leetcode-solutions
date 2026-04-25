/*
 * Problem: 2291. Maximum Profit From Trading Stocks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-profit-from-trading-stocks/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int[] DP = new int[budget + 1];
        for (int i = 0; i < present.length; i++) {
            if (present[i] >= future[i])
                continue;
            for (int j = present[i]; j <= budget; j++) {
                DP[j - present[i]] = Math.max(DP[j] + future[i] - present[i], DP[j - present[i]]);
            }
        }
        int res = 0;
        for (int num : DP) {
            res = Math.max(num, res);
        }
        return res;
    }
}
