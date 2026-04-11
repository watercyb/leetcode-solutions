/*
 * Problem: 1039. Minimum Score Triangulation of Polygon
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int minScoreTriangulation(int[] values) {
        return dfs(new int[values.length + 1][values.length + 1], values, 0, values.length - 1);
    }

    public int dfs(int[][] mems, int[] values, int i, int j) {
        if (j - i < 2)
            return 0;
        if (mems[i][j] != 0)
            return mems[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(values[i] * values[k] * values[j] + dfs(mems,values, i, k) + dfs(mems,values, k, j),
                    res);
        }
        mems[i][j] = res;
        return res;
    }
}
