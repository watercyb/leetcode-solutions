/*
 * Problem: 3299. Sum of Consecutive Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-consecutive-subsequences/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int getSum(int[] nums) {
        int mod = 1_000_000_007;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        long[] lefts1 = new long[max + 1];
        long[] lefts2 = new long[max + 2];
        long[] leftCount1 = new long[nums.length];
        long[] leftCount2 = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lefts1[nums[i]] = (lefts1[nums[i]] + lefts1[nums[i] - 1] + 1) % mod;
            lefts2[nums[i]] = (lefts2[nums[i]] + lefts2[nums[i] + 1] + 1) % mod;
            leftCount1[i] = lefts1[nums[i] - 1] + 1;
            leftCount2[i] = lefts2[nums[i] + 1] + 1;
        }
        long[] rights1 = new long[max + 1];
        long[] rights2 = new long[max + 2];
        long res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            rights1[nums[i]] = (rights1[nums[i]] + rights1[nums[i] - 1] + 1) % mod;
            rights2[nums[i]] = (rights2[nums[i]] + rights2[nums[i] + 1] + 1) % mod;
            res = (res + (leftCount1[i] * (rights2[nums[i] + 1] + 1) % mod
                    + leftCount2[i] * (rights1[nums[i] - 1] + 1) % mod
                    - 1 + mod) * nums[i]) % mod;
        }
        return (int) res;
    }
}

