/*
 * Problem: 1463. Cherry Pickup II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/cherry-pickup-ii/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int cherryPickup(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        int[][] DPOld = new int[cl + 2][cl + 2];
        int[][] DPNew = new int[cl + 2][cl + 2];
        for (int i = 0; i < rl; i++) {
            for (int j = 1; j <= Math.min(cl, i + 1); j++) {
                for (int k = Math.max(1, cl - i); k <= cl; k++) {
                    int max = 0;
                    for (int l = j - 1; l <= j + 1; l++) {
                        for (int m = k - 1; m <= k + 1; m++) {
                            max = Math.max(DPOld[l][m], max);
                        }
                    }
                    if (j != k) {
                        DPNew[j][k] = grid[i][j - 1] + grid[i][k - 1] + max;
                    } else {
                        DPNew[j][k] = grid[i][j - 1] + max;
                    }
                }
            }
            DPOld=DPNew;
            DPNew = new int[cl + 2][cl + 2];
        }
        int max = 0;
        for (int j = 1; j <= Math.min(cl, rl); j++) {
            for (int k = Math.max(0, cl - rl); k <= cl; k++) {
                max = Math.max(DPOld[j][k], max);
            }
        }
        return max;
    }
}
