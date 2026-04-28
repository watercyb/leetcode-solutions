/*
 * Problem: 2580. Count Ways to Group Overlapping Ranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-ways-to-group-overlapping-ranges/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int countWays(int[][] ranges) {
        int mod = 1_000_000_007;
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int lim = -1;
        long res = 1;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] > lim) {
                res = res * 2 % mod;
                lim = ranges[i][1];
            } else {
                if (ranges[i][1] > lim)
                    lim = ranges[i][1];
            }
        }
        return (int) res;
    }
}
