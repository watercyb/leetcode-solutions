/*
 * Problem: 1970. Last Day Where You Can Still Cross
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/last-day-where-you-can-still-cross/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[] links = new int[row * col + 2];
        int top = row * col;
        int bot = row * col + 1;
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        int[][] grid = new int[row][col];
        for (int i = 0; i < col; i++) {
            union(links, col, top, 0, i);
            union(links, col, bot, row - 1, i);
        }
        for (int i = cells.length - 1; i >= 0; i--) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1;
            if (x > 0 && grid[x - 1][y] == 1)
                union(links, col, x, y, x - 1, y);
            if (x < row - 1 && grid[x + 1][y] == 1)
                union(links, col, x, y, x + 1, y);
            if (y > 0 && grid[x][y - 1] == 1)
                union(links, col, x, y, x, y - 1);
            if (y < col - 1 && grid[x][y + 1] == 1)
                union(links, col, x, y, x, y + 1);
            if (find(links, top) == find(links, bot))
                return i;
        }
        return -1;
    }

    public void union(int[] links, int col, int idx, int x2, int y2) {
        int a = find(links, idx);
        int b = find(links, toIdx(x2, y2, col));
        links[a] = b;
    }

    public void union(int[] links, int col, int x1, int y1, int x2, int y2) {
        int a = find(links, toIdx(x1, y1, col));
        int b = find(links, toIdx(x2, y2, col));
        links[a] = b;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }

    public int toIdx(int x, int y, int col) {
        return x * col + y;
    }
}
