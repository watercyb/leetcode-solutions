/*
 * Problem: 2673. Make Costs of Paths Equal in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minIncrements(int n, int[] cost) {
        int res = 0;
        for (int i = n / 2 - 1; i >= 0; i--) {
            int a = cost[2 * i + 1];
            int b = cost[2 * i + 2];
            int max = Math.max(a, b);
            res += 2 * max - a - b;
            cost[i] += max;
        }
        return res;
    }
}
