/*
 * Problem: 3351. Sum of Good Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-good-subsequences/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
        int mod = 1_000_000_007;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        long[] sums = new long[max + 3];
        long[] counts = new long[max + 3];
        long res = 0;
        for (int num : nums) {
            long count = (counts[num] + counts[num + 2] + 1) % mod;
            long sum = (sums[num] + sums[num + 2] + num * count) % mod;
            res = (res + sum) % mod;
            sums[num + 1] = (sums[num + 1] + sum) % mod;
            counts[num + 1] = (counts[num + 1] + count) % mod;
        }
        return (int) res;
    }
}
