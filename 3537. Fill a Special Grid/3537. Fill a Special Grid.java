/*
 * Problem: 3537. Fill a Special Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/fill-a-special-grid/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[][] specialGrid(int N) {
        int a = 1 << N;
        int[][] res = new int[a][a];
        dfs(res, 0, a - 1, 0, a - 1);
        return res;
    }

    int idx = 0;

    public void dfs(int[][] res, int x1, int x2, int y1, int y2) {
        if (x1 == x2) {
            res[x1][y1] = idx++;
        } else {
            int midX = (x1 + x2) >>> 1;
            int midY = (y1 + y2) >>> 1;
            dfs(res, x1, midX, midY + 1, y2);
            dfs(res, midX + 1, x2, midY + 1, y2);
            dfs(res, midX + 1, x2, y1, midY);
            dfs(res, x1, midX, y1, midY);
        }
    }
}
