/*
 * Problem: 1994. The Number of Good Subsets
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-number-of-good-subsets/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        int[] arr = { -1, -1, 1, 1 << 1, -1, 1 << 2, 1 + (1 << 1), 1 << 3, -1, -1, 1 + (1 << 2), 1 << 4, -1,
                1 << 5,
                1 + (1 << 3), (1 << 1) + (1 << 2), -1, 1 << 6, -1, 1 << 7, -1, (1 << 1) + (1 << 3), 1 + (1 << 4),
                1 << 8, -1, -1, 1 + (1 << 5), -1, -1, 1 << 9, 1 + (1 << 1) + (1 << 2) };
        int[] counts = new int[31];
        for (int num : nums) {
            counts[num]++;
        }
        long[] DP = new long[1024];
        for (int i = 2; i <= 30; i++) {
            if (arr[i] < 0 || counts[i] == 0)
                continue;
            int mask = arr[i] ^ (1023);
            for (int j = mask; j > 0; j = (j - 1) & mask) {
                DP[arr[i] + j] = (DP[arr[i] + j] + counts[i] * DP[j]) % mod;
            }
            DP[arr[i]] += counts[i];
        }

        long res = 0;
        for (int i = 1; i < 1024; i++) {
            res = (res + DP[i]) % mod;
        }
        return (int) (res * pow(2, counts[1]) % mod);
    }

    int mod = 1_000_000_007;

    public long pow(int a, long b) {
        long res = 1;
        long base = a;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            b >>= 1;
        }
        return res;
    }
}
