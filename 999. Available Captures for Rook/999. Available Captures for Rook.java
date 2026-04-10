/*
 * Problem: 999. Available Captures for Rook
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/available-captures-for-rook/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    int res = 0;
                    for (int k = i + 1; k < board.length && board[k][j] != 'B'; k++) {
                        if (board[k][j] == 'p') {
                            res++;
                            break;
                        }
                    }
                    for (int k = i - 1; k >= 0 && board[k][j] != 'B'; k--) {
                        if (board[k][j] == 'p') {
                            res++;
                            break;
                        }
                    }
                    for (int k = j + 1; k < board[0].length && board[i][k] != 'B'; k++) {
                        if (board[i][k] == 'p') {
                            res++;
                            break;
                        }
                    }
                    for (int k = j - 1; k >= 0 && board[i][k] != 'B'; k--) {
                        if (board[i][k] == 'p') {
                            res++;
                            break;
                        }
                    }
                    return res;
                }
            }
        }
        return -1;
    }
}
