/*
 * Problem: 2664. The Knight’s Tour
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-knights-tour/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int[][] board = new int[m][n];
        for (int[] row : board) {
            Arrays.fill(row, -1);
        }
        board[r][c] = 0;
        dfs(board, r, c, 1, m * n);
        return board;
    }

    int[][] directions = { { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 }, { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 } };

    public boolean dfs(int[][] board, int i, int j, int n, int target) {
        if (n == target)
            return true;
        List<int[]> list = new ArrayList<>();
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == -1) {
                list.add(new int[] { x, y, count(board, x, y) });
            }
        }
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        for (int[] next : list) {
            board[next[0]][next[1]] = n;
            if (dfs(board, next[0], next[1], n + 1, target))
                return true;
            board[next[0]][next[1]] = -1;
        }
        return false;
    }

    public int count(int[][] board, int i, int j) {
        int count = 0;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == -1) {
                count++;
            }
        }
        return count;
    }
}
