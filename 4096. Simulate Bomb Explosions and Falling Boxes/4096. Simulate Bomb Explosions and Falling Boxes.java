/*
 * Problem: 4096. Simulate Bomb Explosions and Falling Boxes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/simulate-bomb-explosions-and-falling-boxes/
 * Language: java
 * Date: 2026-10-27
 */

class Solution {
    public char[][] finalGrid(char[][] grid) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*')
                    list.add(new int[] { i, j });
            }
        }
        int[][] bombs = new int[list.size()][];
        for (int i = 0; i < bombs.length; i++) {
            bombs[i] = list.get(i);
        }
        while (explode(grid, bombs) || gravity(grid)) {
        }
        return grid;
    }

    int[][] dir4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int[][] dir8 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };

    public boolean explode(char[][] grid, int[][] bombs) {
        List<int[]> list = new ArrayList<>();
        for (int[] bomb : bombs) {
            if (check(grid, bomb))
                list.add(bomb);
        }
        if (list.size() == 0)
            return false;
        for (int[] bomb : list) {
            remove(grid, bomb);
        }
        return true;
    }

    public boolean check(char[][] grid, int[] bomb) {
        for (int[] dir : dir4) {
            int x = bomb[0] + dir[0];
            int y = bomb[1] + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '#')
                return true;
        }
        return false;
    }

    public void remove(char[][] grid, int[] bomb) {
        for (int[] dir : dir8) {
            int x = bomb[0] + dir[0];
            int y = bomb[1] + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '#')
                grid[x][y] = '-';
        }
    }

    public boolean gravity(char[][] grid) {
        boolean changed = false;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = grid.length - 2; j >= 0; j--) {
                if (grid[j][i] == '#' && grid[j + 1][i] == '-') {
                    grid[j + 1][i] = '#';
                    grid[j][i] = '-';
                    changed = true;
                }
            }
        }
        return changed;
    }
}
