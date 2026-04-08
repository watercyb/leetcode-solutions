/*
 * Problem: 730. Count Different Palindromic Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-different-palindromic-subsequences/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int countPalindromicSubsequences(String s) {
        char[] chrs = s.toCharArray();
        int[][] left = new int[chrs.length][];
        int[][] right = new int[chrs.length][];
        int[] idx = { -1, -1, -1, -1 };
        for (int i = 0; i < chrs.length; i++) {
            int j = chrs[i] - 'a';
            idx[j] = i;
            left[i] = idx.clone();
        }
        idx = new int[] { chrs.length, chrs.length, chrs.length, chrs.length };
        for (int i = chrs.length - 1; i >= 0; i--) {
            int j = chrs[i] - 'a';
            idx[j] = i;
            right[i] = idx.clone();
        }
        long res = dfs(left, right, new long[chrs.length][chrs.length], 0, s.length() - 1);
        return (int) (res % mod);
    }

    int mod = 1_000_000_007;

    public long dfs(int[][] left, int[][] right, long[][] meme, int i, int j) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;
        if (meme[i][j] != 0)
            return meme[i][j];
        long res = 0;
        for (char k = 0; k < 4; k++) {
            int l = right[i][k];
            int r = left[j][k];
            if (l < r) {
                res += dfs(left, right, meme, l + 1, r - 1) + 2;
            } else if (l == r) {
                res++;
            }
        }
        res %= mod;
        return meme[i][j] = res;
    }
}
