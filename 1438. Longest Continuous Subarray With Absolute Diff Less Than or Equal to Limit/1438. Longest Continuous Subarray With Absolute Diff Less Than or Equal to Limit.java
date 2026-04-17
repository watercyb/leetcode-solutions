/*
 * Problem: 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int[] MQMax = new int[nums.length];
        int idxMax = 0;
        int prvMax = -1;
        int[] MQMin = new int[nums.length];
        int idxMin = 0;
        int prvMin = -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (prvMax < idxMax && nums[MQMax[prvMax + 1]] - nums[i] > limit) {
                prvMax++;
            }
            int a = -1;
            if (prvMax >= 0)
                a = MQMax[prvMax];
            while (prvMin < idxMin && nums[i] - nums[MQMin[prvMin + 1]] > limit) {
                prvMin++;
            }
            int b = -1;
            if (prvMin >= 0)
                b = MQMin[prvMin];
            if (a < b) {
                while (prvMax < idxMax && MQMax[prvMax + 1] <= b) {
                    prvMax++;
                }
                res = Math.max(i - b, res);
            } else {
                while (prvMin < idxMin && MQMin[prvMin + 1] <= b) {
                    prvMin++;
                }
                res = Math.max(i - a, res);
            }
            while (idxMax > prvMax && nums[i] >= nums[MQMax[idxMax]]) {
                idxMax--;
            }
            MQMax[++idxMax] = i;
            while (idxMin > prvMin && nums[i] <= nums[MQMin[idxMin]]) {
                idxMin--;
            }
            MQMin[++idxMin] = i;
        }
        return res;
    }
}
