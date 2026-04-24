/*
 * Problem: 2110. Number of Smooth Descent Periods of a Stock
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        long len = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                len++;
            } else {
                res += (len + 1) * len / 2;
                len = 1;
            }
        }
        res += (len + 1) * len / 2;
        return res;
    }
}
