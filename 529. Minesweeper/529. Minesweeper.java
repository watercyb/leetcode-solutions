/*
 * Problem: 529. Minesweeper
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minesweeper/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            dfs(board, click[0], click[1]);
        }
        return board;
    }

    public void dfs(char[][] board, int i, int j) {
        int count = getCount(board, i, j);
        if (count > 0) {
            board[i][j] = (char) (count + '0');
        } else {
            board[i][j] = 'B';
            for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                    && board[x][y] == 'E')
                dfs(board, x, y);
            }
        }
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };

    public int getCount(char[][] board, int i, int j) {
        int res = 0;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                    && (board[x][y] == 'M' || board[x][y] == 'X'))
                res++;
        }
        return res;
    }
}
