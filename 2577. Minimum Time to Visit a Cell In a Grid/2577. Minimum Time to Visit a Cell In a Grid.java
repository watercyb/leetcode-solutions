/*
 * Problem: 2577. Minimum Time to Visit a Cell In a Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[1][0] > 1 && grid[0][1] > 1)
            return -1;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        List<int[]>[] stps = new ArrayList[200001];
        Queue<int[]> Qu = new LinkedList<>();
        Qu.offer(new int[] { 0, 0 });
        grid[0][0] = -1;
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = Qu.poll();
                if (current[0] == grid.length - 1 && current[1] == grid[0].length - 1)
                    return stp - 1;
                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] >= 0) {
                        if (grid[x][y] <= stp) {
                            if (stps[stp] == null)
                                stps[stp] = new ArrayList<>();
                            stps[stp].add(new int[] { x, y });
                        } else {
                            int nextStp = grid[x][y] + ((grid[x][y] - stp) & 1);
                            if (stps[nextStp] == null)
                                stps[nextStp] = new ArrayList<>();
                            stps[nextStp].add(new int[] { x, y });
                        }
                        grid[x][y] = -1;
                    }
                }
            }
            while (stp < stps.length) {
                if (stps[stp] != null) {
                    for (int[] arr : stps[stp]) {
                        Qu.offer(arr);
                    }
                    stp++;
                    break;
                }
                stp++;
            }
        }
        return -1;
    }
}
