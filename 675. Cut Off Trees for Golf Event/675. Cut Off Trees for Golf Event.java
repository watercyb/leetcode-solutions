/*
 * Problem: 675. Cut Off Trees for Golf Event
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> list = new ArrayList<>();
        int[][] grid = new int[forest.size()][];
        for (int i = 0; i < grid.length; i++) {
            List<Integer> listTemp = forest.get(i);
            grid[i] = new int[listTemp.size()];
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = listTemp.get(j);
                if (grid[i][j] > 1)
                    list.add(new int[] { i, j, grid[i][j] });
            }
        }
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);
        int x = 0;
        int y = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int stp = bfs(grid, x, y, arr[i][0], arr[i][1]);
            if (stp == -1)
                return -1;
            res += stp;
            x = arr[i][0];
            y = arr[i][1];
        }
        return res;
    }

    int[] arr = new int[2500];

    public int bfs(int[][] grid, int i, int j, int targetX, int targetY) {
        int n = grid[0].length;
        boolean[][] seens = new boolean[grid.length][n];
        int l = 0;
        int r = 0;
        arr[r++] = i * n + j;
        seens[i][j] = true;
        int stp = 0;
        while (l < r) {
            int lim = r;
            while (l < lim) {
                int current = arr[l++];
                int x = current / n;
                int y = current % n;
                if (x == targetX && y == targetY)
                    return stp;
                if (x > 0 && grid[x - 1][y] != 0 && !seens[x - 1][y]) {
                    seens[x - 1][y] = true;
                    arr[r++] = (x - 1) * n + y;
                }
                if (x < grid.length - 1 && grid[x + 1][y] != 0 && !seens[x + 1][y]) {
                    seens[x + 1][y] = true;
                    arr[r++] = (x + 1) * n + y;
                }
                if (y > 0 && grid[x][y - 1] != 0 && !seens[x][y - 1]) {
                    seens[x][y - 1] = true;
                    arr[r++] = x * n + y - 1;
                }
                if (y < grid[0].length - 1 && grid[x][y + 1] != 0 && !seens[x][y + 1]) {
                    seens[x][y + 1] = true;
                    arr[r++] = x * n + y + 1;
                }
            }
            stp++;
        }
        return -1;
    }
}
