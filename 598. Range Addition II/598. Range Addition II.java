/*
 * Problem: 598. Range Addition II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/range-addition-ii/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(op[0], m);
            n = Math.min(op[1], n);
        }
        return m * n;
    }
}
