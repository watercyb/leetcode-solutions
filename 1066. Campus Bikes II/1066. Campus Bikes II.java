/*
 * Problem: 1066. Campus Bikes II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/campus-bikes-ii/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        return dfs(workers, bikes, new int[workers.length][1 << bikes.length], 0, 0);
    }

    public int dfs(int[][] workers, int[][] bikes, int[][] meme, int i, int h) {
        if (i == workers.length)
            return 0;
        if (meme[i][h] != 0)
            return meme[i][h];
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < bikes.length; j++) {
            if ((h & (1 << j)) != 0)
                continue;
            res = Math.min(res, dfs(workers, bikes, meme, i + 1, h + (1 << j)) + dist(workers[i], bikes[j]));
        }
        return meme[i][h] = res;
    }

    public int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
