/*
 * Problem: 1210. Minimum Moves to Reach Target with Rotations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int minimumMoves(int[][] grid) {
        boolean[] steps = new boolean[grid.length * grid[0].length * 2];
        n = grid[0].length * 2;
        int h = getH(0, 0, 0);
        steps[h] = true;
        arr = new int[steps.length];
        arr[r++] = h;
        int stp = 0;
        while (l < r) {
            int lim = r;
            while (l < lim) {
                int[] current = getArr(arr[l++]);
                int x = current[0];
                int y = current[1];
                int ro = current[2];
                if (x == grid.length - 1 && y == grid[0].length - 2)
                    return stp;
                if (ro == 0) {
                    if (x < grid.length - 1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                        update(steps, x, y, 1);
                        update(steps, x + 1, y, 0);
                    }
                    if (y < grid[0].length - 2 && grid[x][y + 2] == 0)
                        update(steps, x, y + 1, 0);
                } else {
                    if (y < grid[0].length - 1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                        update(steps, x, y, 0);
                        update(steps, x, y + 1, 1);
                    }
                    if (x < grid.length - 2 && grid[x + 2][y] == 0)
                        update(steps, x + 1, y, 1);
                }
            }
            stp++;
        }
        return -1;
    }

    int[] arr;
    int l = 0;
    int r = 0;
    int n;

    public void update(boolean[] steps, int x, int y, int ro) {
        int h = getH(x, y, ro);
        if (!steps[h]) {
            steps[h] = true;
            arr[r++] = h;
        }
    }

    public int getH(int x, int y, int r) {
        return x * n + (y << 1) + r;
    }

    public int[] getArr(int h) {
        int[] res = new int[3];
        res[0] = h / n;
        h %= n;
        res[1] = h >> 1;
        res[2] = h & 1;
        return res;
    }
}
