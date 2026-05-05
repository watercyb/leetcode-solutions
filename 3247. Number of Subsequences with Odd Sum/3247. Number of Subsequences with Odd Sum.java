/*
 * Problem: 3247. Number of Subsequences with Odd Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-subsequences-with-odd-sum/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int subsequenceCount(int[] nums) {
        int[] counts = new int[2];
        for (int num : nums) {
            counts[num & 1]++;
        }
        return (int) (pow(counts[1] - 1) * pow(counts[0]) % mod);
    }

    int mod = 1_000_000_007;

    public long pow(int n) {
        if (n < 0)
            return 0;
        long res = 1;
        long base = 2;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            n >>= 1;
        }
        return res;
    }
}
