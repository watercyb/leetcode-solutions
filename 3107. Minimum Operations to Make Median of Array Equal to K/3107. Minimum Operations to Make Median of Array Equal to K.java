/*
 * Problem: 3107. Minimum Operations to Make Median of Array Equal to K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k/?envType=problem-list-v2&envId=sorting
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = nums.length / 2;
        long res = Math.abs(nums[idx] - k);
        for (int i = idx + 1; i < nums.length && nums[i] < k; i++) {
            res += k - nums[i];
        }
        for (int i = idx - 1; i >= 0 && nums[i] > k; i--) {
            res += nums[i] - k;
        }
        return res;
    }
}
