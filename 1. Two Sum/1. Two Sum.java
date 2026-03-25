/*
 * Problem: 1. Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Integer[] idx = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[idx[l]] + nums[idx[r]];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[] { idx[l], idx[r] };
            }
        }
        return new int[] { -1, -1 };
    }
}
