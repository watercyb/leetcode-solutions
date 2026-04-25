/*
 * Problem: 2274. Maximum Consecutive Floors Without Special Floors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int prv = bottom;
        int res = 0;
        for (int sp : special) {
            res = Math.max(res, sp - prv);
            prv = sp + 1;
        }
        res = Math.max(res, top + 1 - prv);
        return res;
    }
}
