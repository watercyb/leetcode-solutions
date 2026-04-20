/*
 * Problem: 1730. Shortest Path to Get Food
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-path-to-get-food/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int getFood(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    Queue<int[]> Qu = new LinkedList<>();
                    Qu.offer(new int[] { i, j });
                    grid[i][j] = 'X';
                    int stp = 1;
                    while (!Qu.isEmpty()) {
                        int size = Qu.size();
                        for (int k = 0; k < size; k++) {
                            int[] current = Qu.poll();
                            int x = current[0];
                            int y = current[1];
                            if (x > 0 && grid[x - 1][y] != 'X') {
                                if (grid[x - 1][y] == '#')
                                    return stp;
                                grid[x - 1][y] = 'X';
                                Qu.offer(new int[] { x - 1, y });
                            }
                            if (x < grid.length - 1 && grid[x + 1][y] != 'X') {
                                if (grid[x + 1][y] == '#')
                                    return stp;
                                grid[x + 1][y] = 'X';
                                Qu.offer(new int[] { x + 1, y });
                            }
                            if (y > 0 && grid[x][y - 1] != 'X') {
                                if (grid[x][y - 1] == '#')
                                    return stp;
                                grid[x][y - 1] = 'X';
                                Qu.offer(new int[] { x, y - 1 });
                            }
                            if (y < grid[0].length - 1 && grid[x][y + 1] != 'X') {
                                if (grid[x][y + 1] == '#')
                                    return stp;
                                grid[x][y + 1] = 'X';
                                Qu.offer(new int[] { x, y + 1 });
                            }
                        }
                        stp++;
                    }
                    return -1;
                }
            }
        }
        return -1;
    }
}
