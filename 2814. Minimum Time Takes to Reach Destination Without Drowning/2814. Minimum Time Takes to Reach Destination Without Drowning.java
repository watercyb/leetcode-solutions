/*
 * Problem: 2814. Minimum Time Takes to Reach Destination Without Drowning
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-takes-to-reach-destination-without-drowning/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int minimumSeconds(List<List<String>> land) {
        int[][] grid = new int[land.size()][land.get(0).size()];
        int[] start = new int[2];
        int[] dist = new int[2];
        Queue<int[]> Qu = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            List<String> list = land.get(i);
            for (int j = 0; j < grid[0].length; j++) {
                switch (list.get(j)) {
                    case ".":
                        grid[i][j] = Integer.MAX_VALUE;
                        break;
                    case "X":
                        grid[i][j] = -1;
                        break;
                    case "*":
                        grid[i][j] = 0;
                        Qu.offer(new int[] { i, j });
                        break;
                    case "D":
                        grid[i][j] = -1;
                        dist = new int[] { i, j };
                        break;
                    case "S":
                        grid[i][j] = Integer.MAX_VALUE;
                        start = new int[] { i, j };
                        break;
                }
            }
        }
        bfs(grid, Qu);
        return bfs(grid, start, dist);
    }

    public void bfs(int[][] grid, Queue<int[]> Qu) {
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
    }

    public int bfs(int[][] grid, int[] start, int[] dist) {
        Queue<int[]> Qu = new LinkedList<>();
        Qu.offer(start);
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = Qu.poll();
                if ((current[0] + 1 == dist[0] && current[1] == dist[1])
                        || (current[0] - 1 == dist[0] && current[1] == dist[1])
                        || (current[0] == dist[0] && current[1] + 1 == dist[1])
                        || (current[0] == dist[0] && current[1] - 1 == dist[1]))
                    return stp;
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
        return -1;
    }
}
