/*
 * Problem: 1368. Minimum Cost to Make at Least One Valid Path in a Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int minCost(int[][] grid) {
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int size = grid.length * grid[0].length * 2;
        int[][] arr = new int[size * 2 + 1][];
        arr[size] = new int[] { 0, 0, 0 };
        int l = size;
        int r = size + 1;
        while (l < r) {
            int[] current = arr[l++];
            if (grid[current[0]][current[1]] != 0) {
                int direction = grid[current[0]][current[1]] - 1;
                grid[current[0]][current[1]] = 0;
                if (current[0] == grid.length - 1 && current[1] == grid[0].length - 1)
                    return current[2];
                for (int i = 0; i < 4; i++) {
                    int x = current[0] + directions[i][0];
                    int y = current[1] + directions[i][1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 0) {
                        if (direction == i) {
                            arr[--l] = new int[] { x, y, current[2] };
                        } else {
                            arr[r++] = new int[] { x, y, current[2] + 1 };
                        }
                    }
                }
            }
        }
        return -1;
    }
}
