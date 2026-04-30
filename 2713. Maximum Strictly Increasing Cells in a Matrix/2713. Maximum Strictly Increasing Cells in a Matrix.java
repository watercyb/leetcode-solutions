/*
 * Problem: 2713. Maximum Strictly Increasing Cells in a Matrix
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-strictly-increasing-cells-in-a-matrix/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                max = Math.max(mat[i][j], max);
                min = Math.min(mat[i][j], min);
            }
        }
        List<int[]>[] lists = new ArrayList[max - min + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (lists[mat[i][j] - min] == null)
                    lists[mat[i][j] - min] = new ArrayList<>();
                lists[mat[i][j] - min].add(new int[] { i, j });
            }
        }
        int[] rowsMax = new int[mat.length];
        int[] colsMax = new int[mat[0].length];
        int res = 0;
        for (List<int[]> list : lists) {
            if (list == null)
                continue;
            List<int[]> rows = new ArrayList<>();
            List<int[]> cols = new ArrayList<>();
            for (int[] arr : list) {
                int c = arr[0];
                int r = arr[1];
                int currentMax = Math.max(rowsMax[c], colsMax[r]) + 1;
                res = Math.max(currentMax, res);
                rows.add(new int[] { c, currentMax });
                cols.add(new int[] { r, currentMax });
            }
            for (int[] arr : rows) {
                rowsMax[arr[0]] = Math.max(arr[1], rowsMax[arr[0]]);
            }
            for (int[] arr : cols) {
                colsMax[arr[0]] = Math.max(arr[1], colsMax[arr[0]]);
            }
        }
        return res;
    }
}
