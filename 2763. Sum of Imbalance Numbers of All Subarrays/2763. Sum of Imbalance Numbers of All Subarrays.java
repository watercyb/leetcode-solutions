/*
 * Problem: 2763. Sum of Imbalance Numbers of All Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-imbalance-numbers-of-all-subarrays/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int[] indexes = new int[nums.length + 1];
        Arrays.fill(indexes, -1);
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = Math.max(indexes[nums[i] - 1], indexes[nums[i]]);
            indexes[nums[i]] = i;
        }
        int res = 0;
        Arrays.fill(indexes, nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            res += (i - left[i]) * (indexes[nums[i] - 1] - i);
            indexes[nums[i]] = i;
        }
        return res - (nums.length + 1) * nums.length / 2;
    }
}
