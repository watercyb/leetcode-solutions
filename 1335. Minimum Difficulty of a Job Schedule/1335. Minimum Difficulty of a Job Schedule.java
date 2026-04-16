/*
 * Problem: 1335. Minimum Difficulty of a Job Schedule
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d)
            return -1;
        int sum = 0;
        for (int i = 0; i < jobDifficulty.length; i++) {
            sum += jobDifficulty[i];
        }
        if (sum == 0) {
            return 0;
        }
        return dfs(new int[jobDifficulty.length][d], jobDifficulty, 0, d - 1) - 1;
    }

    public int dfs(int[][] mems, int[] jobDifficulty, int i, int d) {
        if (i == jobDifficulty.length)
            return 1;
        if (mems[i][d] != 0)
            return mems[i][d];
        if (d == 0) {
            for (int j = i; j < jobDifficulty.length; j++) {
                mems[i][d] = Math.max(jobDifficulty[j], mems[i][d]);
            }
            return ++mems[i][d];
        }
        int max = 0;
        int res = Integer.MAX_VALUE;
        int l = jobDifficulty.length - d - 1;
        for (int j = i; j <= l; j++) {
            max = Math.max(jobDifficulty[j], max);
            res = Math.min(dfs(mems, jobDifficulty, j + 1, d - 1) + max, res);
        }
        mems[i][d] = res;
        return res;
    }
}
