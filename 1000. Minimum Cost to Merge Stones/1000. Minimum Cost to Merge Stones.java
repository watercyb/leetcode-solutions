/*
 * Problem: 1000. Minimum Cost to Merge Stones
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-merge-stones/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int mergeStones(int[] stones, int k) {
        if (k > 2 && stones.length % (k - 1) != 1)
            return -1;
        int[][] DP = new int[stones.length][stones.length];
        int[] sums = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            sums[i + 1] = sums[i] + stones[i];
        }
        for (int i = k - 1; i < stones.length; i++) {
            DP[i - k + 1][i] = sums[i + 1] - sums[i - k + 1];
        }
        return dfs(stones, DP, sums, k, 0, stones.length - 1);
    }

    public int dfs(int[] stones, int[][] DP, int[] sums, int k, int i, int j) {
        if (i == j || DP[i][j] != 0)
            return DP[i][j];
        int res = Integer.MAX_VALUE;
        for (int l = i; l < j; l += k - 1) {
            res = Math.min(dfs(stones, DP, sums, k, i, l) + dfs(stones, DP, sums, k, l + 1, j), res);
        }
        if ((j - i) % (k - 1) == 0)
            res += sums[j + 1] - sums[i];
        return DP[i][j] = res;
    }
}
