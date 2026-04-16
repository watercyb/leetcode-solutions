/*
 * Problem: 1301. Number of Paths with Max Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-paths-with-max-score/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int mod = 1_000_000_007;
        int[][] grids = new int[board.size()][board.getFirst().length()];
        for (int i = 0; i < grids.length; i++) {
            String str = board.get(i);
            for (int j = 0; j < grids[0].length; j++) {
                char chr = str.charAt(j);
                if (chr == 'X') {
                    grids[i][j] = -10000000;
                } else {
                    grids[i][j] = chr - '0';
                }
            }
        }
        grids[0][0] = 0;
        grids[grids.length - 1][grids[0].length - 1] = 0;
        int[][] DP1 = new int[grids.length][grids[0].length];
        int[][] DP2 = new int[grids.length][grids[0].length];
        DP2[grids.length - 1][grids[0].length - 1] = 1;
        for (int i = grids[0].length - 2; i >= 0; i--) {
            DP1[grids.length - 1][i] = DP1[grids.length - 1][i + 1] + grids[grids.length - 1][i];
            DP2[grids.length - 1][i] = 1;
        }
        for (int i = grids.length - 2; i >= 0; i--) {
            DP1[i][grids[0].length - 1] = DP1[i + 1][grids[0].length - 1] + grids[i][grids[0].length - 1];
            DP2[i][grids[0].length - 1] = 1;
        }
        for (int i = grids.length - 2; i >= 0; i--) {
            for (int j = grids[0].length - 2; j >= 0; j--) {
                if (grids[i][j] < 0) {
                    DP1[i][j] = -10000000;
                } else {
                    int max = Math.max(Math.max(DP1[i + 1][j], DP1[i][j + 1]), DP1[i + 1][j + 1]);
                    DP1[i][j] = max + grids[i][j];
                    long sum = 0;
                    if (DP1[i + 1][j] == max)
                        sum = DP2[i + 1][j];
                    if (DP1[i][j + 1] == max)
                        sum += DP2[i][j + 1];
                    if (DP1[i + 1][j + 1] == max)
                        sum += DP2[i + 1][j + 1];
                    DP2[i][j] = (int) (sum % mod);
                }
            }
        }
        if (DP1[0][0] < 0)
            return new int[] { 0, 0 };
        return new int[] { DP1[0][0], DP2[0][0] };
    }
}
