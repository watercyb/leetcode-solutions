/*
 * Problem: 1030. Matrix Cells in Distance Order
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/matrix-cells-in-distance-order/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][];
        int idx = 0;
        int[][] arr = new int[res.length][];
        int l = 0;
        int r = 1;
        arr[0] = new int[] { rCenter, cCenter };
        boolean[][] seens = new boolean[rows][cols];
        seens[rCenter][cCenter] = true;
        while (l < r) {
            int[] current = arr[l++];
            res[idx++] = current;
            int x = current[0];
            int y = current[1];
            if (x > 0 && !seens[x - 1][y]) {
                seens[x - 1][y] = true;
                arr[r++] = new int[] { x - 1, y };
            }
            if (x < rows - 1 && !seens[x + 1][y]) {
                seens[x + 1][y] = true;
                arr[r++] = new int[] { x + 1, y };
            }
            if (y > 0 && !seens[x][y - 1]) {
                seens[x][y - 1] = true;
                arr[r++] = new int[] { x, y - 1 };
            }
            if (y < cols - 1 && !seens[x][y + 1]) {
                seens[x][y + 1] = true;
                arr[r++] = new int[] { x, y + 1 };
            }
        }
        return res;
    }
}
