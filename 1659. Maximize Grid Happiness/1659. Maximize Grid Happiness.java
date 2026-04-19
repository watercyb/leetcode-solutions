/*
 * Problem: 1659. Maximize Grid Happiness
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-grid-happiness/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        meme = new int[m][n][(int) Math.pow(3, n)][introvertsCount + 1][extrovertsCount + 1];
        return dfs(new int[n], new int[n], 0, m - 1, 0, 0, introvertsCount, extrovertsCount);
    }

    int[][][][][] meme;

    int[][] nums = { { 0, 0, 0 }, { 0, -60, -10 }, { 0, -10, 40 } };
    int[] pows = { 1, 3, 9, 27, 81, 243 };

    public int dfs(int[] arr, int[] arrPrv, int h, int i, int j, int prv, int iC, int eC) {
        if (i == -1) {
            return 0;
        } else if (j == arrPrv.length) {
            if (iC + eC == 0)
                return 0;
            return dfs(arrPrv, new int[arr.length], h, i - 1, 0, 0, iC, eC);
        } else {
            if (meme[i][j][h][iC][eC] != 0)
                return meme[i][j][h][iC][eC];
            int res = 0;
            if (iC > 0) {
                arrPrv[j] = 1;
                res = Math.max(
                        dfs(arr, arrPrv, h + (1 - arr[j]) * pows[j], i, j + 1, 1, iC - 1, eC) + 120 + nums[1][arr[j]]
                                + nums[1][prv],
                        res);
            }
            if (eC > 0) {
                arrPrv[j] = 2;
                res = Math.max(
                        dfs(arr, arrPrv, h + (2 - arr[j]) * pows[j], i, j + 1, 2, iC, eC - 1) + 40 + nums[2][arr[j]]
                                + nums[2][prv],
                        res);
            }
            arrPrv[j] = 0;
            res = Math.max(dfs(arr, arrPrv, h - arr[j] * pows[j], i, j + 1, 0, iC, eC), res);
            return meme[i][j][h][iC][eC] = res;
        }
    }
}
