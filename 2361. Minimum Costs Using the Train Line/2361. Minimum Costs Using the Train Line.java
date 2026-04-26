/*
 * Problem: 2361. Minimum Costs Using the Train Line
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-costs-using-the-train-line/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[] res = new long[regular.length];
        long a = 0;
        long b = expressCost;
        for (int i = 0; i < regular.length; i++) {
            long aNext = Math.min(a, b) + regular[i];
            long bNext = Math.min(a + expressCost, b) + express[i];
            res[i] = Math.min(aNext, bNext);
            a = aNext;
            b = bNext;
        }
        return res;
    }
}
