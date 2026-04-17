/*
 * Problem: 1444. Number of Ways of Cutting a Pizza
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int ways(String[] pizza, int k) {
        int row = pizza.length;
        int col = pizza[0].length();
        rowSum = new int[row + 1][col + 1];
        colSum = new int[row + 1][col + 1];
        boolean isEmpty = true;
        for (int i = 0; i < row; i++) {
            char[] chrs = pizza[i].toCharArray();
            for (int j = 0; j < chrs.length; j++) {
                if (chrs[j] == 'A') {
                    isEmpty = false;
                    rowSum[i + 1][j + 1] = rowSum[i + 1][j] + 1;
                    colSum[i + 1][j + 1] = colSum[i][j + 1] + 1;
                } else {
                    rowSum[i + 1][j + 1] = rowSum[i + 1][j];
                    colSum[i + 1][j + 1] = colSum[i][j + 1];
                }
            }
        }
        if (isEmpty)
            return 0;
        long res = dfs(new Long[row][col][k], 0, row - 1, 0, col - 1, k - 1);
        return (int) (res % mod);
    }

    int mod = 1_000_000_007;
    int[][] rowSum;
    int[][] colSum;

    public long dfs(Long[][][] mems, int row1, int row2, int col1, int col2, int k) {
        if (k == 0)
            return 1;
        if (mems[row1][col1][k] != null)
            return mems[row1][col1][k];
        long res = 0;
        int l = row1;
        int r = row2;
        while (l < r && rowSum[l + 1][col2 + 1] - rowSum[l + 1][col1] == 0) {
            l++;
        }
        while (r > l && rowSum[r + 1][col2 + 1] - rowSum[r + 1][col1] == 0) {
            r--;
        }
        for (int i = l; i < r; i++) {
            res += dfs(mems, i + 1, row2, col1, col2, k - 1);
        }
        l = col1;
        r = col2;
        while (l < r && colSum[row2 + 1][l + 1] - colSum[row1][l + 1] == 0) {
            l++;
        }
        while (r > l && colSum[row2 + 1][r + 1] - colSum[row1][r + 1] == 0) {
            r--;
        }
        for (int i = l; i < r; i++) {
            res += dfs(mems, row1, row2, i + 1, col2, k - 1);
        }
        return mems[row1][col1][k] = res;
    }
}
