/*
 * Problem: 2123. Minimum Operations to Remove Adjacent Ones in Matrix
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-remove-adjacent-ones-in-matrix/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minimumOperations(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] pairs = new int[r * c];
        Arrays.fill(pairs, -1);
        int res = 0;
        int[] seens = new int[pairs.length];
        int stp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && pairs[i * c + j] == -1 && dfs(grid, seens, pairs, i * c + j, ++stp)) {
                    res++;
                }
            }
        }
        return res;
    }

    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean dfs(int[][] grid, int[] seens, int[] pairs, int h, int stp) {
        if (seens[h] == stp)
            return false;
        seens[h] = stp;
        int i = h / grid[0].length;
        int j = h % grid[0].length;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                int next = x * grid[0].length + y;
                if (pairs[next] == -1 || (seens[next] != stp && dfs(grid, seens, pairs, pairs[next], stp))) {
                    pairs[next] = h;
                    pairs[h] = next;
                    return true;
                }
            }
        }
        return false;
    }
}
