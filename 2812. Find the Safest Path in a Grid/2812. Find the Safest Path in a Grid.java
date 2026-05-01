/*
 * Problem: 2812. Find the Safest Path in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-safest-path-in-a-grid/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int row = grid.size();
        int col = grid.get(0).size();
        int[][] arr = new int[row][col];
        Queue<int[]> Qu = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> tmp = grid.get(i);
            for (int j = 0; j < col; j++) {
                arr[i][j] = tmp.get(j);
                if (arr[i][j] == 1) {
                    Qu.offer(new int[] { i, j });
                    arr[i][j] = -1;
                }
            }
        }
        int stp = 0;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            stp++;
            for (int i = 0; i < size; i++) {
                int[] tmp = Qu.poll();
                int x = tmp[0];
                int y = tmp[1];
                if (x > 0 && arr[x - 1][y] == 0) {
                    arr[x - 1][y] = stp;
                    Qu.offer(new int[] { x - 1, y });
                }
                if (x < arr.length - 1 && arr[x + 1][y] == 0) {
                    arr[x + 1][y] = stp;
                    Qu.offer(new int[] { x + 1, y });
                }
                if (y > 0 && arr[x][y - 1] == 0) {
                    arr[x][y - 1] = stp;
                    Qu.offer(new int[] { x, y - 1 });
                }
                if (y < arr[0].length - 1 && arr[x][y + 1] == 0) {
                    arr[x][y + 1] = stp;
                    Qu.offer(new int[] { x, y + 1 });
                }
            }
        }
        int l = 0;
        int r = Math.min(arr[0][0], arr[arr.length - 1][arr[0].length - 1]) + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!dfs(arr, new boolean[row][col], 0, 0, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return Math.max(l - 1, 0);
    }

    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean dfs(int[][] arr, boolean[][] seens, int i, int j, int mid) {
        if (arr[i][j] < mid)
            return false;
        if (i == arr.length - 1 && j == arr.length - 1)
            return true;
        if (i > 0 && !seens[i - 1][j]) {
            seens[i - 1][j] = true;
            if (dfs(arr, seens, i - 1, j, mid))
                return true;
        }
        if (i < arr.length - 1 && !seens[i + 1][j]) {
            seens[i + 1][j] = true;
            if (dfs(arr, seens, i + 1, j, mid))
                return true;
        }
        if (j > 0 && !seens[i][j - 1]) {
            seens[i][j - 1] = true;
            if (dfs(arr, seens, i, j - 1, mid))
                return true;
        }
        if (j < arr[0].length - 1 && !seens[i][j + 1]) {
            seens[i][j + 1] = true;
            if (dfs(arr, seens, i, j + 1, mid))
                return true;
        }
        return false;
    }
}
