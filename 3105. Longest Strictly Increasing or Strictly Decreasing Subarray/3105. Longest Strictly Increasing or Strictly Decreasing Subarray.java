/*
 * Problem: 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 0;
        int prv = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (prv > 0) {
                if (nums[i] > prv) {
                    count++;
                    prv = nums[i];
                } else if (nums[i] < prv) {
                    res = Math.max(count, res);
                    count = 2;
                    prv = -nums[i];
                } else {
                    res = Math.max(count, res);
                    count = 1;
                    prv = nums[i];
                }
            } else {
                if (nums[i] > -prv) {
                    res = Math.max(count, res);
                    count = 2;
                    prv = nums[i];
                } else if (nums[i] < -prv) {
                    count++;
                    prv = -nums[i];
                } else {
                    res = Math.max(count, res);
                    count = 1;
                    prv = nums[i];
                }
            }
        }
        res = Math.max(count, res);
        return res;
    }
}
