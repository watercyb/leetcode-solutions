/*
 * Problem: 51. N-Queens
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/n-queens/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new boolean[n][n], new boolean[n], new boolean[2][n * 2], n, 0);
        return res;
    }

    public void dfs(List<List<String>> res, boolean[][] arr, boolean[] occupiedY, boolean[][] occupiedCross,
            int n, int i) {
        if (i == n) {
            List<String> tmp = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                StringBuilder SB = new StringBuilder();
                for (int l = 0; l < n; l++) {
                    if (arr[k][l]) {
                        SB.append('Q');
                    } else {
                        SB.append('.');
                    }
                }
                tmp.add(SB.toString());
            }
            res.add(tmp);
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
                    dfs(res, arr, occupiedY, occupiedCross, n, i + 1);
                    occupiedY[j] = false;
                    occupiedCross[0][cross1] = false;
                    occupiedCross[1][cross2] = false;
                    arr[i][j] = false;
                }
            }
        }
    }
}
