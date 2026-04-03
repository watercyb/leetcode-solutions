/*
 * Problem: 474. Ones and Zeroes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/ones-and-zeroes/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] DP = new int[m + 1][n + 1];
        DP[0][0] = 1;
        for (String str : strs) {
            int[] counts = new int[2];
            for (char chr : str.toCharArray()) {
                counts[chr - '0']++;
            }
            for (int i = m - counts[0]; i >= 0; i--) {
                for (int j = n - counts[1]; j >= 0; j--) {
                    if (DP[i][j] > 0)
                        DP[i + counts[0]][j + counts[1]] = Math.max(DP[i][j] + 1, DP[i + counts[0]][j + counts[1]]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                res = Math.max(DP[i][j], res);
            }
        }
        return res - 1;
    }
}
