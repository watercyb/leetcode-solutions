/*
 * Problem: 808. Soup Servings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/soup-servings/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public double soupServings(int n) {
        if (n == 0)
            return 0.5;
        if (n > 5000)
            return 1;
        int t = (n + 24) / 25;
        return dfs(new Double[t + 1][t + 1], t, t);
    }

    public double dfs(Double[][] meme, int a, int b) {
        if (a <= 0) {
            if (b > 0) {
                return 0;
            } else {
                return 0.5;
            }
        }
        if (b <= 0)
            return 1;
        if (meme[a][b] != null)
            return meme[a][b];
        return meme[a][b] = (dfs(meme, a - 3, b - 1) + dfs(meme, a - 2, b - 2) + dfs(meme, a - 1, b - 3)
                + dfs(meme, a, b - 4)) / 4;
    }
}
