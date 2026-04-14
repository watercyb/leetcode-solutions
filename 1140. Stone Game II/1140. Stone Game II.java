/*
 * Problem: 1140. Stone Game II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/stone-game-ii/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int stoneGameII(int[] piles) {
        int[] sums = new int[piles.length];
        sums[piles.length - 1] = piles[piles.length - 1];
        for (int i = piles.length - 2; i >= 0; i--) {
            sums[i] = sums[i + 1] + piles[i];
        }
        return dfs(piles, new int[piles.length][piles.length + 1], sums, 0, 1);
    }

    public int dfs(int[] piles, int[][] meme, int[] sums, int i, int m) {
        if (i == piles.length)
            return 0;
        if (meme[i][m] != 0)
            return meme[i][m];
        if (i + 2 * m >= piles.length)
            return meme[i][m] = sums[i];
        int min = Integer.MAX_VALUE;
        for (int j = i; j < i + 2 * m; j++) {
            min = Math.min(dfs(piles, meme, sums, j + 1, Math.max(j - i + 1, m)), min);
        }
        return meme[i][m] = sums[i] - min;
    }
}
