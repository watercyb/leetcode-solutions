/*
 * Problem: 3567. Minimum Absolute Difference in Sliding Submatrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n - k + 1][m - k + 1];
        if (k == 1)
            return res;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = getDiff(grid, i, j, k);
            }
        }
        return res;
    }

    public int getDiff(int[][] grid, int i, int j, int k) {
        int[] arr = new int[k * k];
        int idx = 0;
        for (int l = 0; l < k; l++) {
            for (int m = 0; m < k; m++) {
                arr[idx++] = grid[l + i][m + j];
            }
        }
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int l = 1; l < arr.length; l++) {
            if (arr[l] == arr[l - 1])
                continue;
            res = Math.min(arr[l] - arr[l - 1], res);
        }
        if (res == Integer.MAX_VALUE)
            return 0;
        return res;
    }
}
