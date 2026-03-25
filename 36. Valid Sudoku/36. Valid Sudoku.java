/*
 * Problem: 36. Valid Sudoku
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-sudoku/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] regions = new boolean[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int idx = i / 3 * 3 + j / 3;
                    if (rows[i][num] || cols[j][num] || regions[idx][num])
                        return false;
                    rows[i][num] = cols[j][num] = regions[idx][num] = true;
                }
            }
        }
        return true;
    }
}
