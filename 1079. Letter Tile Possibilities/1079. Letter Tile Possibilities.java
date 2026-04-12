/*
 * Problem: 1079. Letter Tile Possibilities
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/letter-tile-possibilities/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] counts = new int[26];
        for (char chr : tiles.toCharArray()) {
            counts[chr - 'A']++;
        }
        int len = tiles.length();
        int res = 0;
        int[][] meme = new int[26][len + 1];
        for (int i = 1; i <= len; i++) {
            int a = dfs(counts, meme, 0, i);
            res += a;
        }
        return res;
    }

    public int dfs(int[] counts, int[][] meme, int i, int n) {
        if (n == 0)
            return 1;
        if (i == counts.length)
            return 0;
        if (counts[i] == 0)
            return dfs(counts, meme, i + 1, n);
        if (meme[i][n] != 0)
            return meme[i][n];
        int res = 0;
        for (int j = 0; j <= Math.min(counts[i], n); j++) {
            res += dfs(counts, meme, i + 1, n - j) * C(n, j);
        }
        return meme[i][n] = res;
    }

    public int C(int a, int b) {
        int res = 1;
        int c = 1;
        for (int i = 1; i <= b; i++) {
            res *= a;
            c *= i;
            a--;
        }
        return res / c;
    }
}
