/*
 * Problem: 351. Android Unlock Patterns
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/android-unlock-patterns/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skipped = new int[10][10];
        skipped[1][3] = skipped[3][1] = 2;
        skipped[4][6] = skipped[6][4] = 5;
        skipped[7][9] = skipped[9][7] = 8;
        skipped[1][7] = skipped[7][1] = 4;
        skipped[2][8] = skipped[8][2] = 5;
        skipped[3][9] = skipped[9][3] = 6;
        skipped[1][9] = skipped[9][1] = 5;
        skipped[3][7] = skipped[7][3] = 5;
        boolean[] seens = new boolean[10];
        int res = 4 * dfs(seens, skipped, 1, 1, m, n);
        res += 4 * dfs(seens, skipped, 2, 1, m, n);
        res += dfs(seens, skipped, 5, 1, m, n);
        return res;
    }

    public int dfs(boolean[] seens, int[][] skipped, int i, int count, int m, int n) {
        int res = 0;
        if (count >= m)
            res++;
        seens[i] = true;
        if (count < n) {
            for (int j = 1; j <= 9; j++) {
                if (!seens[j] && (skipped[i][j] == 0 || seens[skipped[i][j]])) {
                    res += dfs(seens, skipped, j, count + 1, m, n);
                }
            }
        }
        seens[i] = false;
        return res;
    }
}
