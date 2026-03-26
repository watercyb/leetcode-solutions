/*
 * Problem: 130. Surrounded Regions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/surrounded-regions/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public void solve(char[][] board) {
        int rl = board.length - 1;
        int cl = board[0].length - 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'o';
                DFS(board, i, 0);
            }
            if (board[i][cl] == 'O') {
                board[i][cl] = 'o';
                DFS(board, i, cl);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'o';
                DFS(board, 0, i);
            }
            if (board[rl][i] == 'O') {
                board[rl][i] = 'o';
                DFS(board, rl, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'o') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void DFS(char[][] board, int i, int j) {
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (board[x][y] == 'O') {
                    board[x][y] = 'o';
                    DFS(board, x, y);
                }
            }
        }
    }
}
