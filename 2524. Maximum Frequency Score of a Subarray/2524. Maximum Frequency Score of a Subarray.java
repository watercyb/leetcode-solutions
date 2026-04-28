/*
 * Problem: 2524. Maximum Frequency Score of a Subarray
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-frequency-score-of-a-subarray/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int maxFrequencyScore(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int count = ++counts[nums[i]];
            if (count == 1) {
                sum = (sum + nums[i]) % mod;
            } else {
                sum = (sum + pow(nums[i], count - 1) * (nums[i] - 1)) % mod;
            }
        }
        long res = sum;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] == nums[i - k])
                continue;
            int count = ++counts[nums[i]];
            if (count == 1) {
                sum = (sum + nums[i]) % mod;
            } else {
                sum = (sum + pow(nums[i], count - 1) * (nums[i] - 1)) % mod;
            }
            count = --counts[nums[i - k]];
            if (count == 0) {
                sum = (sum - nums[i - k]) % mod;
            } else {
                sum = ((sum - pow(nums[i - k], count) * (nums[i - k] - 1)) % mod + mod) % mod;
            }
            res = Math.max(sum, res);
        }
        return (int) res;
    }

    int mod = 1_000_000_007;

    public long pow(int a, int b) {
        long res = 1;
        long base = a;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            b /= 2;
        }
        return res;
    }
}
