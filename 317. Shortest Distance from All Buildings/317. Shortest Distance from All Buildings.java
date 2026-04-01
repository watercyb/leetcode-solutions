/*
 * Problem: 317. Shortest Distance from All Buildings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-distance-from-all-buildings/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int shortestDistance(int[][] grid) {
        int[][] counts = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    if (!getDist(grid, counts, i, j, count))
                        return -1;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0 && counts[i][j] == count) {
                    res = Math.min(-grid[i][j], res);
                }
            }
        }
        return res;
    }

    public boolean getDist(int[][] grid, int[][] counts, int i, int j, int count) {
        boolean[][] tmp = new boolean[grid.length][grid[0].length];
        Queue<int[]> Qu = new LinkedList<>();
        Qu.add(new int[] { i, j });
        int dist = 1;
        while (!Qu.isEmpty()) {
            int n = Qu.size();
            for (int k = 0; k < n; k++) {
                int[] stp = Qu.poll();
                if (stp[0] - 1 >= 0 && !tmp[stp[0] - 1][stp[1]]) {
                    if (grid[stp[0] - 1][stp[1]] <= 0) {
                        tmp[stp[0] - 1][stp[1]] = true;
                        grid[stp[0] - 1][stp[1]] -= dist;
                        counts[stp[0] - 1][stp[1]]++;
                        Qu.add(new int[] { stp[0] - 1, stp[1] });
                    } else if (grid[stp[0] - 1][stp[1]] == 1) {
                        count--;
                        tmp[stp[0] - 1][stp[1]] = true;
                    }
                }
                if (stp[0] + 1 < grid.length && !tmp[stp[0] + 1][stp[1]]) {
                    if (grid[stp[0] + 1][stp[1]] <= 0) {
                        tmp[stp[0] + 1][stp[1]] = true;
                        grid[stp[0] + 1][stp[1]] -= dist;
                        counts[stp[0] + 1][stp[1]]++;
                        Qu.add(new int[] { stp[0] + 1, stp[1] });
                    } else if (grid[stp[0] + 1][stp[1]] == 1) {
                        count--;
                        tmp[stp[0] + 1][stp[1]] = true;
                    }
                }
                if (stp[1] - 1 >= 0 && !tmp[stp[0]][stp[1] - 1]) {
                    if (grid[stp[0]][stp[1] - 1] <= 0) {
                        tmp[stp[0]][stp[1] - 1] = true;
                        grid[stp[0]][stp[1] - 1] -= dist;
                        counts[stp[0]][stp[1] - 1]++;
                        Qu.add(new int[] { stp[0], stp[1] - 1 });
                    } else if (grid[stp[0]][stp[1] - 1] == 1) {
                        count--;
                        tmp[stp[0]][stp[1] - 1] = true;
                    }
                }
                if (stp[1] + 1 < grid[0].length && !tmp[stp[0]][stp[1] + 1]) {
                    if (grid[stp[0]][stp[1] + 1] <= 0) {
                        tmp[stp[0]][stp[1] + 1] = true;
                        grid[stp[0]][stp[1] + 1] -= dist;
                        counts[stp[0]][stp[1] + 1]++;
                        Qu.add(new int[] { stp[0], stp[1] + 1 });
                    } else if (grid[stp[0]][stp[1] + 1] == 1) {
                        count--;
                        tmp[stp[0]][stp[1] + 1] = true;
                    }
                }
            }
            dist++;
        }
        return count == 0;
    }
}
