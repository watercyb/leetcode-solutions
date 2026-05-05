/*
 * Problem: 3290. Maximum Multiplication Score
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-multiplication-score/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long maxScore(int[] a, int[] b) {
        long[] DP = new long[4];
        Arrays.fill(DP, Long.MIN_VALUE / 2);
        for (int num : b) {
            for (int i = 3; i >= 1; i--) {
                DP[i] = Math.max(DP[i], DP[i - 1] + (long) a[i] * num);
            }
            DP[0] = Math.max(DP[0], (long) a[0] * num);
        }
        return DP[3];
    }
}
