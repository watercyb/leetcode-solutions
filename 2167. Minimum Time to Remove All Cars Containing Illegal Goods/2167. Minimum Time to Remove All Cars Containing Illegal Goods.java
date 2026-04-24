/*
 * Problem: 2167. Minimum Time to Remove All Cars Containing Illegal Goods
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        int dp = 0;
        int res = n;
        for (int i = 0; i < n; i++) {
            dp = Math.min(dp + 2 * (s.charAt(i) - '0'), i + 1);
            res = Math.min(res, dp + n - 1 - i);
        }
        return res;
    }
}
