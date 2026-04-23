/*
 * Problem: 2008. Maximum Earnings From Taxi
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-earnings-from-taxi/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]>[] lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] ride : rides) {
            lists[ride[1]].add(new int[] { ride[0], ride[1] - ride[0] + ride[2] });
        }
        long[] DP = new long[n + 2];
        for (int i = 0; i <= n; i++) {
            DP[i + 1] = DP[i];
            if (lists[i].isEmpty())
                continue;
            for (int[] arr : lists[i]) {
                DP[i + 1] = Math.max(DP[arr[0] + 1] + arr[1], DP[i + 1]);
            }
        }
        return DP[n + 1];
    }
}
