/*
 * Problem: 375. Guess Number Higher or Lower II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int getMoneyAmount(int n) {
        return dfs(new int[n + 1][n + 1], 1, n);
    }

    public int dfs(int[][] meme, int l, int r) {
        if (l >= r)
            return 0;
        if (meme[l][r] != 0)
            return meme[l][r];
        int mid = (l + r) / 2;
        int res = Integer.MAX_VALUE;
        for (int j = r; j >= mid; j--) {
            int re = Math.max(dfs(meme, l, j - 1), dfs(meme, j + 1, r)) + j;
            if (re <= res) {
                res = re;
            } else {
                break;
            }
        }
        return meme[l][r] = res;
    }
}
