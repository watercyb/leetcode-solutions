/*
 * Problem: 3874. Valid Subarrays With Exactly One Peak
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-subarrays-with-exactly-one-peak/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long validSubarrays(int[] nums, int k) {
        int lim = -1;
        int[] lefts = new int[nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                lefts[i] = i - lim;
                lim = i;
            }
        }
        long res = 0;
        lim = nums.length;
        for (int i = nums.length - 2; i > 0; i--) {
            if (lefts[i] > 0) {
                res += (long) (Math.min(lefts[i], k + 1)) * (Math.min(lim - i, k + 1));
                lim = i;
            }
        }
        return res;
    }
}
