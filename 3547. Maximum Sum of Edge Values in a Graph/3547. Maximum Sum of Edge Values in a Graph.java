/*
 * Problem: 3547. Maximum Sum of Edge Values in a Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-sum-of-edge-values-in-a-graph/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long maxScore(int n, int[][] edges) {
        long res = (long) n * (n - 1);
        if (n == edges.length)
            res += 2;
        for (long i = 3; i <= n; i++) {
            res += i * (i - 2);
        }
        return res;
    }
}
