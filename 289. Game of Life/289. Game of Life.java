/*
 * Problem: 289. Game of Life
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/game-of-life/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int sum = colSum(board, i, 0);
            for (int j = 0; j < board[0].length; j++) {
                sum = sum + colSum(board, i, j + 1) - colSum(board, i, j - 2);
                int ner = sum - board[i][j];
                if ((board[i][j] == 1 && (ner == 2 || ner == 3)) || (board[i][j] == 0 && ner == 3)) {
                    board[i][j] += 10;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] /= 10;
            }
        }
    }

    public int colSum(int[][] board, int i, int j) {
        if (j < 0 || j >= board[0].length)
            return 0;
        int res = 0;
        for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, board.length); k++) {
            res += board[k][j];
        }
        return res % 10;
    }
}
