/*
 * Problem: 2466. Count Ways To Build Good Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-ways-to-build-good-strings/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        int min = Math.min(zero, one);
        int max = zero + one - min;
        int[] DP = new int[high + max + 1];
        DP[max - 1] = 1;
        for (int i = max; i <= high + max; i++) {
            DP[i] = (DP[i - min] + DP[i - max]) % mod;
        }
        int res = 0;
        for (int i = low + max - 1; i < high + max; i++) {
            res = (res + DP[i]) % mod;
        }
        return res;
    }
}
