/*
 * Problem: 910. Smallest Range II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-range-ii/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int max = Math.max(nums[0] + k, nums[nums.length - 1] - k);
        int min = Math.min(nums[0] + k, nums[nums.length - 1] - k);
        int res = nums[nums.length - 1] - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.min(res, Math.max(max, nums[i] + k) - Math.min(min, nums[i + 1] - k));
        }
        return res;
    }
}
