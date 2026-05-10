/*
 * Problem: 3738. Longest Non-Decreasing Subarray After Replacing at Most One Element
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-non-decreasing-subarray-after-replacing-at-most-one-element/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int[] lefts = new int[nums.length];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            lefts[i] = len;
            if (nums[i] >= nums[i - 1]) {
                len++;
            } else {
                len = 1;
            }
        }
        int[] rights = new int[nums.length];
         len = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rights[i] = len;
            if (nums[i] <= nums[i + 1]) {
                len++;
            } else {
                len = 1;
            }
        }
        int res = Math.max(lefts[nums.length - 1], rights[0]) + 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] <= nums[i + 1]) {
                res = Math.max(res, lefts[i] + rights[i] + 1);
            } else {
                res = Math.max(res, Math.max(lefts[i], rights[i ]) + 1);
            }
        }
        return res;
    }
}
