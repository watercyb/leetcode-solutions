/*
 * Problem: 1263. Minimum Moves to Move a Box to Their Target Location
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int minPushBox(char[][] grid) {
        int max = Math.max(grid.length, grid[0].length);
        arr[2] = max;
        arr[1] = arr[2] * max;
        arr[0] = arr[1] * max;
        seens = new boolean[arr[0] * max];
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int xTarget = 0;
        int yTarget = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'S') {
                    x1 = i;
                    y1 = j;
                } else if (grid[i][j] == 'B') {
                    x2 = i;
                    y2 = j;
                } else if (grid[i][j] == 'T') {
                    xTarget = i;
                    yTarget = j;
                }
            }
        }
        Deque<int[]> Dq = new ArrayDeque<>();
        Dq.offer(new int[] { x1, y1, x2, y2, 0 });
        while (!Dq.isEmpty()) {
            int[] node = Dq.poll();
            if (node[2] == xTarget && node[3] == yTarget)
                return node[4];
            dfs(grid, Dq, new boolean[grid.length][grid[0].length], node[0], node[1], node[2], node[3],
                    node[4] + 1);
        }
        return -1;
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    boolean[] seens;
    int[] arr = new int[3];

    public void dfs(char[][] grid, Deque<int[]> Dq, boolean[][] meme, int x1, int y1, int x2, int y2,
            int stp) {
        meme[x1][y1] = true;
        for (int[] direction : directions) {
            int x = x1 + direction[0];
            int y = y1 + direction[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !meme[x][y] && grid[x][y] != '#') {
                if (x == x2 && y == y2) {
                    int xNext = x + direction[0];
                    int yNext = y + direction[1];
                    if (xNext >= 0 && xNext < grid.length && yNext >= 0 && yNext < grid[0].length
                            && grid[x][y] != '#') {
                        int h = x1 * arr[0] + y1 * arr[1] + x2 * arr[2] + y2;
                        if (!seens[h]) {
                            seens[h] = true;
                            Dq.offerLast(new int[] { x, y, xNext, yNext, stp });
                        }
                    }
                } else {
                    dfs(grid, Dq, meme, x, y, x2, y2, stp);
                }
            }
        }
    }
}
