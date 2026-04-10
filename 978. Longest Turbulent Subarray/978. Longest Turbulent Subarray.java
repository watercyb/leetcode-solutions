/*
 * Problem: 978. Longest Turbulent Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-turbulent-subarray/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int[] DP = new int[2];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                DP[0] = DP[1] + 1;
                DP[1] = 0;
                max = Math.max(DP[0], max);
            } else if (arr[i] > arr[i - 1]) {
                DP[1] = DP[0] + 1;
                DP[0] = 0;
                max = Math.max(DP[1], max);
            } else {
                DP[0] = 0;
                DP[1] = 0;
            }
        }
        return max + 1;
    }
}
