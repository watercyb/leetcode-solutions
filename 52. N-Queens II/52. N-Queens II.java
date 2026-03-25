/*
 * Problem: 52. N-Queens II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/n-queens-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int totalNQueens(int n) {
        res = 0;
        dfs(new boolean[n][n], new boolean[n], new boolean[2][n * 2], n, 0);
        return res;
    }

    int res = 0;

    public void dfs(boolean[][] arr, boolean[] occupiedY, boolean[][] occupiedCross,
            int n, int i) {
        if (i == n) {
            res++;
        } else {
            for (int j = 0; j < n; j++) {
                int cross1 = j + i;
                int cross2 = j - i + n;
                if (!occupiedY[j] && !occupiedCross[0][cross1]
                        && !occupiedCross[1][cross2]) {
                    occupiedY[j] = true;
                    occupiedCross[0][cross1] = true;
                    occupiedCross[1][cross2] = true;
                    arr[i][j] = true;
                    dfs(arr, occupiedY, occupiedCross, n, i + 1);
                    occupiedY[j] = false;
                    occupiedCross[0][cross1] = false;
                    occupiedCross[1][cross2] = false;
                    arr[i][j] = false;
                }
            }
        }
    }
}
