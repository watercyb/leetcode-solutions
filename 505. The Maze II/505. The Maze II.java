/*
 * Problem: 505. The Maze II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-maze-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        PQ.add(new int[] { start[0], start[1], 0 });
        while (!PQ.isEmpty()) {
            int[] currentStp = PQ.poll();
            if (currentStp[0] == destination[0] && currentStp[1] == destination[1])
                return currentStp[2];
            int x = currentStp[0];
            int count = 0;
            while (x > 0 && maze[x - 1][currentStp[1]] != 1) {
                x--;
                count++;
            }
            if (x != currentStp[0] && (maze[x][currentStp[1]] == 0
                    || (maze[x][currentStp[1]] < -(currentStp[2] + count)))) {
                maze[x][currentStp[1]] = -(currentStp[2] + count);
                PQ.offer(new int[] { x, currentStp[1], currentStp[2] + count });
            }
            x = currentStp[0];
            count = 0;
            while (x < maze.length - 1 && maze[x + 1][currentStp[1]] != 1) {
                x++;
                count++;
            }
            if (x != currentStp[0]
                    && (maze[x][currentStp[1]] == 0 || (maze[x][currentStp[1]] < -(currentStp[2] + count)))) {
                maze[x][currentStp[1]] = -(currentStp[2] + count);
                PQ.offer(new int[] { x, currentStp[1], currentStp[2] + count });
            }
            int y = currentStp[1];
            count = 0;
            while (y > 0 && maze[currentStp[0]][y - 1] != 1) {
                y--;
                count++;
            }
            if (y != currentStp[1]
                    && (maze[currentStp[0]][y] == 0 || (maze[currentStp[0]][y] < -(currentStp[2] + count)))) {
                maze[currentStp[0]][y] = -(currentStp[2] + count);
                PQ.offer(new int[] { currentStp[0], y, currentStp[2] + count });
            }
            y = currentStp[1];
            count = 0;
            while (y < maze[0].length - 1 && maze[currentStp[0]][y + 1] != 1) {
                y++;
                count++;
            }
            if (y != currentStp[1]
                    && (maze[currentStp[0]][y] == 0 || (maze[currentStp[0]][y] < -(currentStp[2] + count)))) {
                maze[currentStp[0]][y] = -(currentStp[2] + count);
                PQ.offer(new int[] { currentStp[0], y, currentStp[2] + count });
            }
        }
        return -1;
    }
}
