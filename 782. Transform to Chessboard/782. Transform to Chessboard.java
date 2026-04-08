/*
 * Problem: 782. Transform to Chessboard
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/transform-to-chessboard/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int movesToChessboard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int a = board[0][0] ^ board[i][0];
            for (int j = 0; j < board.length; j++) {
                if ((a ^ board[0][j] ^ board[i][j]) == 1)
                    return -1;
            }
        }
        int rowCount = 0;
        int rowTotal = 0;
        int colCount = 0;
        int colTotal = 0;
        for (int i = 0; i < board.length; i++) {
            if ((i & 1) == 0) {
                rowCount += board[i][0];
                colCount += board[0][i];
            }
            rowTotal += board[i][0];
            colTotal += board[0][i];
        }
        if (board.length % 2 == 0) {
            if (2 * rowTotal != board.length || 2 * colTotal != board.length)
                return -1;
            return Math.min(rowCount, (board.length + 1) / 2 - rowCount)
                    + Math.min(colCount, (board.length + 1) / 2 - colCount);
        } else {
            if (Math.abs(2 * rowTotal - board.length) > 1 || Math.abs(2 * colTotal - board.length) > 1)
                return -1;
            return (2 * rowTotal > board.length ? (board.length + 1) / 2 - rowCount
                    : rowCount) + (2 * colTotal > board.length ? (board.length + 1) / 2 - colCount : colCount);
        }
    }
}
