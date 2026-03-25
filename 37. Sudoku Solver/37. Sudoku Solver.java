/*
 * Problem: 37. Sudoku Solver
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sudoku-solver/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] r = new boolean[9][9];
        boolean[][] l = new boolean[9][9];
        boolean[][] sb = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int tmp = board[i][j] - '1';
                    r[i][tmp] = true;
                    l[j][tmp] = true;
                    sb[i / 3 * 3 + j / 3][tmp] = true;
                }
            }
        }
        dfs(r, l, sb, board, 0);
    }

    public boolean dfs(boolean[][] r, boolean[][] l, boolean[][] sb, char[][] board, int n) {
        if (n == 81)
            return true;
        int i = n / 9;
        int j = n % 9;
        int k = i / 3 * 3 + j / 3;
        if (board[i][j] != '.') {
            if (dfs(r, l, sb, board, n + 1))
                return true;
        } else {
            for (int m = 0; m < 9; m++) {
                if (!r[i][m] && !l[j][m] && !sb[k][m]) {
                    board[i][j] = (char) (m + '1');
                    r[i][m] = true;
                    l[j][m] = true;
                    sb[k][m] = true;
                    if (dfs(r, l, sb, board, n + 1))
                        return true;
                    board[i][j] = '.';
                    r[i][m] = false;
                    l[j][m] = false;
                    sb[k][m] = false;
                }
            }
        }
        return false;
    }
}
