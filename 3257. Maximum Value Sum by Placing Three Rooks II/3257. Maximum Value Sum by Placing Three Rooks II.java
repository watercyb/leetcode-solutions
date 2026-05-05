/*
 * Problem: 3257. Maximum Value Sum by Placing Three Rooks II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-value-sum-by-placing-three-rooks-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long maximumValueSum(int[][] board) {
        int[][] seens = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            int[] max = new int[] { -1, -1, -1 };
            for (int j = 0; j < board[0].length; j++) {
                if (max[0] == -1 || board[i][j] > board[i][max[0]]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = j;
                } else if (max[1] == -1 || board[i][j] > board[i][max[1]]) {
                    max[2] = max[1];
                    max[1] = j;
                } else if (max[2] == -1 || board[i][j] > board[i][max[2]]) {
                    max[2] = j;
                }
            }
            for (int j = 0; j < 3; j++) {
                seens[i][max[j]] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < board[0].length; i++) {
            int[] max = new int[] { -1, -1, -1 };
            for (int j = 0; j < board.length; j++) {
                if (max[0] == -1 || board[j][i] > board[max[0]][i]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = j;
                } else if (max[1] == -1 || board[j][i] > board[max[1]][i]) {
                    max[2] = max[1];
                    max[1] = j;
                } else if (max[2] == -1 || board[j][i] > board[max[2]][i]) {
                    max[2] = j;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (seens[max[j]][i]++ == 1)
                    count++;
            }
        }
        int[][] arr = new int[count][];
        int idx = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (seens[i][j] == 2)
                    arr[idx++] = new int[] { i, j, board[i][j] };
            }
        }
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);
        long res = Long.MIN_VALUE;
        for (int i = 0; i < Math.min(15, arr.length) - 2; i++) {
            int[] a = arr[i];
            for (int j = i + 1; j < Math.min(15, arr.length) - 1; j++) {
                int[] b = arr[j];
                if (a[0] == b[0] || a[1] == b[1])
                    continue;
                long sum = board[a[0]][a[1]] + board[b[0]][b[1]];
                for (int k = j + 1; k < Math.min(15, arr.length); k++) {
                    int[] c = arr[k];
                    if (c[0] == a[0] || c[1] == a[1] || c[0] == b[0] || c[1] == b[1])
                        continue;
                    res = Math.max(sum + board[c[0]][c[1]], res);
                }
            }
        }
        return res;
    }
}
