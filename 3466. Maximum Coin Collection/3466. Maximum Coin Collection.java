/*
 * Problem: 3466. Maximum Coin Collection
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-coin-collection/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long maxCoins(int[] lane1, int[] lane2) {
        long a = 0;
        long b = 0;
        long c = 0;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < lane1.length; i++) {
            a += lane1[i];
            b += lane2[i];
            c += lane1[i];
            c = Math.max(c, b);
            b = Math.max(b, a);
            res = Math.max(Math.max(b, c), res);
            if (a < 0)
                a = 0;
            if (b < 0)
                b = 0;
        }
        return res;
    }
}
