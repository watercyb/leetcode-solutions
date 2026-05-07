/*
 * Problem: 3459. Length of Longest V-Shaped Diagonal Segment
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int[][] a1 = new int[grid.length][grid[0].length];
        int[][] a2 = new int[grid.length][grid[0].length];
        int[][] b1 = new int[grid.length][grid[0].length];
        int[][] b2 = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            getA(grid, a1, a2, i, 0);
            getB(grid, b1, b2, i, grid[0].length - 1);
        }
        for (int i = 1; i < grid[0].length - 1; i++) {
            getA(grid, a1, a2, 0, i);
            getB(grid, b1, b2, 0, i);
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int x = i + 1;
                    int y = j + 1;
                    int prv = 0;
                    int n = 1;
                    while (x < grid.length && y < grid[0].length && prv + grid[x][y] == 2) {
                        n++;
                        res = Math.max(n + b1[x][y], res);
                        prv = grid[x][y];
                        x++;
                        y++;
                    }
                    res = Math.max(n, res);
                    x = i + 1;
                    y = j - 1;
                    prv = 0;
                    n = 1;
                    while (x < grid.length && y >= 0 && prv + grid[x][y] == 2) {
                        n++;
                        res = Math.max(n + a2[x][y], res);
                        prv = grid[x][y];
                        x++;
                        y--;
                    }
                    res = Math.max(n, res);
                    x = i - 1;
                    y = j - 1;
                    prv = 0;
                    n = 1;
                    while (x >= 0 && y >= 0 && prv + grid[x][y] == 2) {
                        n++;
                        res = Math.max(n + b2[x][y], res);
                        prv = grid[x][y];
                        x--;
                        y--;
                    }
                    res = Math.max(n, res);
                    x = i - 1;
                    y = j + 1;
                    prv = 0;
                    n = 1;
                    while (x >= 0 && y < grid[0].length && prv + grid[x][y] == 2) {
                        n++;
                        res = Math.max(n + a1[x][y], res);
                        prv = grid[x][y];
                        x--;
                        y++;
                    }
                    res = Math.max(n, res);
                }
            }
        }
        return res;
    }

    public void getA(int[][] grid, int[][] a1, int[][] a2, int x, int y) {
        int dX = 1;
        int dY = 1;
        if (x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == 1) {
            getA(grid, a1, a2, x + dX, y + dY);
            return;
        }
        int prv = grid[x][y];
        int n = 0;
        int x1 = x + dX;
        int y1 = y + dY;
        while (x1 < grid.length && y1 < grid[0].length && prv + grid[x1][y1] == 2) {
            n++;
            a2[x1][y1] = n;
            prv = grid[x1][y1];
            x1 += dX;
            y1 += dY;
        }
        while (n > 0) {
            a1[x][y] = n;
            n--;
            x += dX;
            y += dY;
        }
        getA(grid, a1, a2, x + dX, y + dY);
    }

    public void getB(int[][] grid, int[][] b1, int[][] b2, int x, int y) {
        int dX = 1;
        int dY = -1;
        if (x >= grid.length || y < 0) {
            return;
        }
        if (grid[x][y] == 1) {
            getB(grid, b1, b2, x + dX, y + dY);
            return;
        }
        int prv = grid[x][y];
        int n = 0;
        int x1 = x + dX;
        int y1 = y + dY;
        while (x1 < grid.length && y1 >= 0 && prv + grid[x1][y1] == 2) {
            n++;
            b2[x1][y1] = n;
            prv = grid[x1][y1];
            x1 += dX;
            y1 += dY;
        }
        while (n > 0) {
            b1[x][y] = n;
            n--;
            x += dX;
            y += dY;
        }
        getB(grid, b1, b2, x + dX, y + dY);
    }
}
