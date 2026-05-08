/*
 * Problem: 3558. Number of Ways to Assign Edge Weights I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0] - 1].add(edge[1] - 1);
            lists[edge[1] - 1].add(edge[0] - 1);
        }
        return pow(dfs(lists, 0, -1));
    }

    public int pow(int a) {
        long res = 1;
        long base = 2;
        while (a > 0) {
            if ((a & 1) == 1)
                res = res * base % 1_000_000_007;
            base = base * base % 1_000_000_007;
            a /= 2;
        }
        return (int) res;
    }

    public int dfs(List<Integer>[] lists, int i, int prv) {
        int res = -2;
        for (int next : lists[i]) {
            if (next == prv)
                continue;
            res = Math.max(dfs(lists, next, i), res);
        }
        return res + 1;
    }
}
