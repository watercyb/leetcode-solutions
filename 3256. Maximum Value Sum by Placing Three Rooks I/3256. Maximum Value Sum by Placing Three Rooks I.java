/*
 * Problem: 3256. Maximum Value Sum by Placing Three Rooks I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-value-sum-by-placing-three-rooks-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long maximumValueSum(int[][] board) {
        int[][] arr = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            arr[i] = getMax(board[i]);
        }
        dfs(board, arr, new boolean[board[0].length], 0, 0, 0);
        return res;
    }

    long res = Long.MIN_VALUE;

    public void dfs(int[][] board, int[][] arr, boolean[] used, int i, long sum, int n) {
        if (n == 3) {
            res = Math.max(sum, res);
            return;
        }
        if (i == arr.length)
            return;
        dfs(board, arr, used, i + 1, sum, n);
        for (int j = 0; j < 3; j++) {
            if (!used[arr[i][j]]) {
                used[arr[i][j]] = true;
                dfs(board, arr, used, i + 1, sum + board[i][arr[i][j]], n + 1);
                used[arr[i][j]] = false;
            }
        }
    }

    public int[] getMax(int[] row) {
        int[] res = { -1, -1, -1 };
        for (int i = 0; i < row.length; i++) {
            if (res[0] == -1 || row[i] > row[res[0]]) {
                res[2] = res[1];
                res[1] = res[0];
                res[0] = i;
            } else if (res[1] == -1 || row[i] > row[res[1]]) {
                res[2] = res[1];
                res[1] = i;
            } else if (res[2] == -1 || row[i] > row[res[2]]) {
                res[2] = i;
            }
        }
        return res;
    }
}
