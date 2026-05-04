/*
 * Problem: 3197. Find the Minimum Area to Cover All Ones II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-ii/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumSum(int[][] grid) {
        rows = new int[grid.length];
        cols = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows[i] += 1 << j;
                    cols[j] += 1 << i;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                res = Math.min(res,
                        Math.min(
                                getArea(0, i, j + 1, grid[0].length - 1)
                                        + getArea(i + 1, grid.length - 1, 0, grid[0].length - 1),
                                getArea(0, grid.length - 1, j + 1, grid[0].length - 1)
                                        + getArea(i + 1, grid.length - 1, 0, j))
                                + getArea(0, i, 0, j));
                res = Math.min(res,
                        Math.min(
                                getArea(i + 1, grid.length - 1, 0, j)
                                        + getArea(i + 1, grid.length - 1, j + 1, grid[0].length - 1)
                                        + getArea(0, i, 0, grid[0].length - 1),
                                getArea(0, i, 0, j)
                                        + getArea(0, i, j + 1, grid[0].length - 1)
                                        + getArea(i + 1, grid.length - 1, 0, grid[0].length - 1)));
                res = Math.min(res,
                        Math.min(
                                getArea(0, i, j + 1, grid[0].length - 1)
                                        + getArea(i + 1, grid.length - 1, j + 1, grid[0].length - 1)
                                        + getArea(0, grid.length - 1, 0, j),
                                getArea(0, i, 0, j)
                                        + getArea(i + 1, grid.length - 1, 0, j)
                                        + getArea(0, grid.length - 1, j + 1, grid[0].length - 1)));
            }
        }
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = i + 1; j < grid.length - 1; j++)
                res = Math.min(res,
                        getArea(0, i, 0, grid[0].length - 1)
                                + getArea(i + 1, j, 0, grid[0].length - 1)
                                + getArea(j + 1, grid.length - 1, 0, grid[0].length - 1));
        }
        for (int i = 0; i < grid[0].length - 2; i++) {
            for (int j = i + 1; j < grid[0].length - 1; j++)
                res = Math.min(res,
                        getArea(0, grid.length - 1, 0, i)
                                + getArea(0, grid.length - 1, i + 1, j)
                                + getArea(0, grid.length - 1, j + 1, grid[0].length - 1));
        }
        return res;
    }

    int[] rows;
    int[] cols;

    public int getArea(int x1, int x2, int y1, int y2) {
        int row = 0;
        for (int i = x1; i <= x2; i++) {
            row |= rows[i];
        }
        row &= (1 << (y2 + 1)) - (1 << y1);
        if (row == 0)
            return Integer.MAX_VALUE / 3;
        int col = 0;
        for (int i = y1; i <= y2; i++) {
            col |= cols[i];
        }
        col &= (1 << (x2 + 1)) - (1 << x1);
        if (col == 0)
            return Integer.MAX_VALUE / 3;
        int l = (int) (Math.log(row & -row) / Math.log(2));
        int r = 31 - Integer.numberOfLeadingZeros(row);
        int t = (int) (Math.log(col & -col) / Math.log(2));
        int b = 31 - Integer.numberOfLeadingZeros(col);
        return (b - t + 1) * (r - l + 1);
    }
}
