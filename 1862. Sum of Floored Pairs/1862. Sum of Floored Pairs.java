/*
 * Problem: 1862. Sum of Floored Pairs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-floored-pairs/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        int mod = 1_000_000_007;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        for (int i = 1; i <= max; i++) {
            counts[i] += counts[i - 1];
        }
        long res = 0;
        for (int i = 1; i <= max; i++) {
            if (counts[i] - counts[i - 1] == 0)
                continue;
            long sum = 0;
            int prv = i;
            for (long j = 1; prv <= max; j++) {
                int idx = prv + i;
                sum += j * (counts[Math.min(idx - 1, max)] - counts[prv - 1]);
                prv = idx;
            }
            res = (res + sum * (counts[i] - counts[i - 1])) % mod;
        }
        return (int) res;
    }
}
