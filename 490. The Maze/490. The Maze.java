/*
 * Problem: 490. The Maze
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-maze/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start[0], start[1], destination);
    }

    public boolean dfs(int[][] maze, int i, int j, int[] destination) {
        if (i == destination[0] && j == destination[1])
            return true;
        maze[i][j] = 2;
        int x = i;
        while (x > 0 && maze[x - 1][j] != 1) {
            x--;
        }
        if (x != i && maze[x][j] == 0 && dfs(maze, x, j, destination))
            return true;
        x = i;
        while (x < maze.length - 1 && maze[x + 1][j] != 1) {
            x++;
        }
        if (x != i && maze[x][j] == 0 && dfs(maze, x, j, destination))
            return true;
        int y = j;
        while (y > 0 && maze[i][y - 1] != 1) {
            y--;
        }
        if (y != j && maze[i][y] == 0 && dfs(maze, i, y, destination))
            return true;
        y = j;
        while (y < maze[0].length - 1 && maze[i][y + 1] != 1) {
            y++;
        }
        if (y != j && maze[i][y] == 0 && dfs(maze, i, y, destination))
            return true;
        return false;
    }
}
