/*
 * Problem: 3540. Minimum Time to Visit All Houses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-visit-all-houses/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long minTotalTime(int[] forward, int[] backward, int[] queries) {
        long[] sums1 = new long[forward.length + 1];
        for (int i = 0; i < forward.length; i++) {
            sums1[i + 1] = sums1[i] + forward[i];
        }
        long[] sums2 = new long[backward.length + 1];
        for (int i = backward.length - 1; i >= 0; i--) {
            sums2[i] = sums2[i + 1] + backward[i];
        }
        long res = 0;
        int prv = 0;
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] < prv) {
                long a = sums1[forward.length] - (sums1[prv] - sums1[queries[i]]);
                long b = sums2[queries[i] + 1] - sums2[prv + 1];
                res += Math.min(a, b);
            } else if (queries[i] > prv) {
                long a = sums1[queries[i]] - sums1[prv];
                long b = sums2[0] - (sums2[prv + 1] - sums2[queries[i] + 1]);
                res += Math.min(a, b);
            }
            prv = queries[i];
        }
        return res;
    }
}
