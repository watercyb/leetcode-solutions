/*
 * Problem: 79. Word Search
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/word-search/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chrs = word.toCharArray();
        boolean[][] seen = new boolean[board.length][board[0].length];
        int[] counts = new int['z' + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                counts[board[i][j]]++;
            }
        }
        for (char chr : chrs) {
            counts[chr]--;
            if (counts[chr] < 0)
                return false;
        }
        if (counts[chrs[0]] > counts[chrs[chrs.length - 1]]) {
            int l = 0;
            int r = chrs.length - 1;
            while (l < r) {
                char tmp = chrs[l];
                chrs[l] = chrs[r];
                chrs[r] = tmp;
                l++;
                r--;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chrs[0]) {
                    seen[i][j] = true;
                    if (dfs(seen, board, chrs, i, j, 1))
                        return true;
                    seen[i][j] = false;
                }
            }
        }
        return false;
    }

    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean dfs(boolean[][] seen, char[][] board, char[] chrs, int i, int j, int n) {
        if (n == chrs.length)
            return true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !seen[x][y]
                    && board[x][y] == chrs[n]) {
                seen[x][y] = true;
                if (dfs(seen, board, chrs, x, y, n + 1))
                    return true;
                seen[x][y] = false;
            }
        }
        return false;
    }
}
