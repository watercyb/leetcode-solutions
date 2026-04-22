/*
 * Problem: 1906. Minimum Absolute Difference Queries
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-absolute-difference-queries/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[][] counts = new int[nums.length + 1][];
        counts[0] = new int[100];
        int[] freqs = new int[100];
        for (int i = 0; i < nums.length; i++) {
            freqs[nums[i] - 1]++;
            counts[i + 1] = freqs.clone();
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int prv = -Integer.MAX_VALUE / 2;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 100; j++) {
                if (counts[r][j] - counts[l][j] > 0) {
                    min = Math.min(min, j - prv);
                    prv = j;
                }
            }
            if (min >= Integer.MAX_VALUE / 2) {
                res[i] = -1;
            } else {
                res[i] = min;
            }
        }
        return res;
    }
}
