/*
 * Problem: 994. Rotting Oranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rotting-oranges/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> Qu = new LinkedList<>();
        int counts=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j]=-1;
                    Qu.add(new int[] { i, j });
                } else if (grid[i][j] == 1){
                    counts++;
                }
            }
        }
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int[] stp={0,0};
        while (!Qu.isEmpty()) {
            stp = Qu.poll();
            for (int[] dir : dirs) {
                int x = stp[0] + dir[0];
                int y = stp[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                    grid[x][y] = grid[stp[0]][stp[1]] - 1;
                    counts--;
                    Qu.add(new int[] { x, y });
                }
            }
        }
        if (counts>0) return -1;
        if (grid[stp[0]][stp[1]]==0) return 0;
        return -grid[stp[0]][stp[1]]-1;
    }
}
