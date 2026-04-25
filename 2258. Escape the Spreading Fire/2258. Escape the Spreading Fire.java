/*
 * Problem: 2258. Escape the Spreading Fire
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/escape-the-spreading-fire/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maximumMinutes(int[][] grid) {
        Queue<int[]> Qu = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    Qu.offer(new int[] { i, j });
                } else if (grid[i][j] == 0) {
                    grid[i][j] = Integer.MAX_VALUE;
                } else {
                    grid[i][j] = -1;
                }
            }
        }
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = Qu.poll();
                if (current[0] > 0 && grid[current[0] - 1][current[1]] > stp) {
                    grid[current[0] - 1][current[1]] = stp;
                    Qu.offer(new int[] { current[0] - 1, current[1] });
                }
                if (current[0] < grid.length - 1 && grid[current[0] + 1][current[1]] > stp) {
                    grid[current[0] + 1][current[1]] = stp;
                    Qu.offer(new int[] { current[0] + 1, current[1] });
                }
                if (current[1] > 0 && grid[current[0]][current[1] - 1] > stp) {
                    grid[current[0]][current[1] - 1] = stp;
                    Qu.offer(new int[] { current[0], current[1] - 1 });
                }
                if (current[1] < grid[0].length - 1 && grid[current[0]][current[1] + 1] > stp) {
                    grid[current[0]][current[1] + 1] = stp;
                    Qu.offer(new int[] { current[0], current[1] + 1 });
                }
            }
            stp++;
        }
        if (grid[grid.length - 1][grid[0].length - 1] < Integer.MAX_VALUE)
            grid[grid.length - 1][grid[0].length - 1]++;
        int l = 0;
        int r = grid.length * grid[0].length + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(grid, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l == grid.length * grid[0].length + 1)
            return 1_000_000_000;
        return l - 1;
    }

    public boolean chk(int[][] grid, int mid) {
        boolean[][] seens = new boolean[grid.length][grid[0].length];
        Queue<int[]> Qu = new LinkedList<>();
        Qu.offer(new int[] { 0, 0 });
        seens[0][0] = true;
        int stp = mid + 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = Qu.poll();
                if (current[0] > 0 && grid[current[0] - 1][current[1]] > stp && !seens[current[0] - 1][current[1]]) {
                    seens[current[0] - 1][current[1]] = true;
                    Qu.offer(new int[] { current[0] - 1, current[1] });
                }
                if (current[0] < grid.length - 1 && grid[current[0] + 1][current[1]] > stp
                        && !seens[current[0] + 1][current[1]]) {
                    if (current[0] == grid.length - 2 && current[1] == grid[0].length - 1)
                        return true;
                    seens[current[0] + 1][current[1]] = true;
                    Qu.offer(new int[] { current[0] + 1, current[1] });
                }
                if (current[1] > 0 && grid[current[0]][current[1] - 1] > stp && !seens[current[0]][current[1] - 1]) {
                    seens[current[0]][current[1] - 1] = true;
                    Qu.offer(new int[] { current[0], current[1] - 1 });
                }
                if (current[1] < grid[0].length - 1 && grid[current[0]][current[1] + 1] > stp
                        && !seens[current[0]][current[1] + 1]) {
                    if (current[0] == grid.length - 1 && current[1] == grid[0].length - 2)
                        return true;
                    seens[current[0]][current[1] + 1] = true;
                    Qu.offer(new int[] { current[0], current[1] + 1 });
                }
            }
            stp++;
        }
        return false;
    }
}
