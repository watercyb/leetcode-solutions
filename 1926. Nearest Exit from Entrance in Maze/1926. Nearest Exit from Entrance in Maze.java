/*
 * Problem: 1926. Nearest Exit from Entrance in Maze
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> Qu = new LinkedList<>();
        Qu.offer(new int[] { entrance[0], entrance[1] });
        maze[entrance[0]][entrance[1]] = '+';
        int stp = 0;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = Qu.poll();
                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];
                    if (x < 0 || x == maze.length || y < 0 || y == maze[0].length) {
                        if (stp > 0)
                            return stp;
                    } else if (maze[x][y] == '.') {
                        maze[x][y] = '+';
                        Qu.offer(new int[] { x, y });
                    }
                }
            }
            stp++;
        }
        return -1;
    }
}
