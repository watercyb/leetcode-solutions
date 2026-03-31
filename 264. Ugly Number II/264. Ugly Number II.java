/*
 * Problem: 264. Ugly Number II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/ugly-number-ii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int nthUglyNumber(int n) {
        long[] DP = new long[n];
        DP[0] = 1;
        int j = 0;
        int k = 0;
        int l = 0;
        for (int i = 1; i < n; i++) {
            DP[i] = Math.min(Math.min(DP[l] * 2, DP[k] * 3), DP[j] * 5);
            if (DP[i] == DP[l]  * 2)
                l++;
            if (DP[i]  == DP[k]  * 3)
                k++;
            if (DP[i]  == DP[j] * 5)
                j++;
        }
        return (int) DP[n - 1];
    }
}
