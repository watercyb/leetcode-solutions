/*
 * Problem: 2289. Steps to Make Array Non-decreasing
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/steps-to-make-array-non-decreasing/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int totalSteps(int[] nums) {
        int[] MQ = new int[nums.length];
        int[] stps = new int[nums.length];
        int idx = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            while (idx > 0 && MQ[idx - 1] <= nums[i]) {
                max = Math.max(stps[idx - 1], max);
                idx--;
            }
            if (idx == 0) {
                max = 0;
            } else {
                max++;
            }
            MQ[idx] = nums[i];
            stps[idx] = max;
            idx++;
            res = Math.max(max, res);
        }
        return res;
    }
}
