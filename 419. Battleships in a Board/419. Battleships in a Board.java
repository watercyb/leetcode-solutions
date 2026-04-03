/*
 * Problem: 419. Battleships in a Board
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/battleships-in-a-board/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        if (board[0][0] == 'X')
            res++;
        for (int i = 1; i < board.length; i++) {
            if (board[i][0] == 'X' && board[i - 1][0] == '.') {
                res++;
            }
        }
        for (int i = 1; i < board[0].length; i++) {
            if (board[0][i] == 'X' && board[0][i - 1] == '.') {
                res++;
            }
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 'X' && board[i - 1][j] == '.' && board[i][j - 1] == '.') {
                    res++;
                }
            }
        }
        return res;
    }
}
