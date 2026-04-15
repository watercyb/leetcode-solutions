/*
 * Problem: 1240. Tiling a Rectangle with the Fewest Squares
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int tilingRectangle(int n, int m) {
        dfs(new int[n], n, m, 0);
        return res;
    }

    int res = Integer.MAX_VALUE;

    public void dfs(int[] rows, int x, int y, int n) {
        if (n >= res)
            return;
        int min = 0;
        for (int i = 1; i < rows.length; i++) {
            if (rows[i] < rows[min])
                min = i;
        }
        if (rows[min] == y) {
            res = Math.min(n, res);
        } else {
            int idx = min + 1;
            while (idx < x && rows[idx] == rows[min]) {
                idx++;
            }
            int lim = Math.min(y - rows[min], idx - min);
            int ori = rows[min];
            for (int i = min; i < min + lim; i++) {
                rows[i] += lim;
            }
            dfs(rows, x, y, n + 1);
            rows[min + lim - 1] = ori;
            for (int i = lim - 1; i >= 1; i--) {
                for (int j = min; j < min + i; j++) {
                    rows[j]--;
                }
                dfs(rows, x, y, n + 1);
                rows[min + i - 1] = ori;
            }
        }
    }
}
