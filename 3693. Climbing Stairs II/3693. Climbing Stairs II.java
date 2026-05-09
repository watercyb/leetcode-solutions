/*
 * Problem: 3693. Climbing Stairs II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/climbing-stairs-ii/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = a;
            a = Math.min(b, temp + costs[i] + 1);
            if (i + 1 < costs.length)
                b = Math.min(c, temp + costs[i + 1] + 4);
            if (i + 2 < costs.length)
                c = temp + costs[i + 2] + 9;
        }
        return a;
    }
}
