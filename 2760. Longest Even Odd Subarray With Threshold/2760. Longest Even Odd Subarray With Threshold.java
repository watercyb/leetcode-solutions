/*
 * Problem: 2760. Longest Even Odd Subarray With Threshold
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l = 0;
        int res = 0;
        while (l < nums.length) {
            if (nums[l] % 2 == 0 && nums[l] <= threshold) {
                int r = l + 1;
                int target = 1;
                while (r < nums.length && nums[r] <= threshold && nums[r] % 2 == target) {
                    r++;
                    target = 1 - target;
                }
                res = Math.max(res, r - l);
                l = r;
            } else {
                l++;
            }
        }
        return res;
    }
}
