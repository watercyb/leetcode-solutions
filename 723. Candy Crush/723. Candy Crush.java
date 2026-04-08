/*
 * Problem: 723. Candy Crush
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/candy-crush/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean isChanged = true;
        while (isChanged) {
            isChanged = chk(board);
        }
        return board;
    }

    public boolean chk(int[][] board) {
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            int prv = -1;
            int count = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    prv = -1;
                    continue;
                }
                if (Math.abs(board[i][j]) != prv) {
                    prv = Math.abs(board[i][j]);
                    count = 1;
                } else {
                    count++;
                    if (count == 3) {
                        res = true;
                        board[i][j - 2] = -prv;
                        board[i][j - 1] = -prv;
                        board[i][j] = -prv;
                    } else if (count > 3) {
                        board[i][j] = -prv;
                    }
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            int prv = -1;
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 0) {
                    prv = -1;
                    continue;
                }
                if (Math.abs(board[j][i]) != prv) {
                    prv = Math.abs(board[j][i]);
                    count = 1;
                } else {
                    count++;
                    if (count == 3) {
                        res = true;
                        board[j - 2][i] = -prv;
                        board[j - 1][i] = -prv;
                        board[j][i] = -prv;
                    } else if (count > 3) {
                        board[j][i] = -prv;
                    }
                }
            }
        }
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] < 0) {
                    int a = i;
                    int b = i - 1;
                    while (b >= 0 && board[b][j] < 0) {
                        b--;
                    }
                    for (int k = b; k >= 0; k--) {
                        board[a][j] = board[k][j];
                        a--;
                    }
                    while (a >= 0) {
                        board[a][j] = 0;
                        a--;
                    }
                }
            }
        }
        return res;
    }
}
