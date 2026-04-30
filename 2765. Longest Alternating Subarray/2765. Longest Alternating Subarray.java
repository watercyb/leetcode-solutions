/*
 * Problem: 2765. Longest Alternating Subarray
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-alternating-subarray/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int l = 0;
        while (l < nums.length - 1) {
            if (nums[l + 1] - nums[l] == 1) {
                int p = 1;
                int r = l + 1;
                while (r < nums.length - 1 && nums[r + 1] - nums[r] == -p) {
                    r++;
                    p = -p;
                }
                res = Math.max(res, r - l + 1);
                l = r;
            } else {
                l++;
            }
        }
        return res;
    }
}
