/*
 * Problem: 1950. Maximum of Minimum Values in All Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-of-minimum-values-in-all-subarrays/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] findMaximums(int[] nums) {
        int[] MQ = new int[nums.length + 1];
        int idx = 1;
        MQ[0] = -1;
        int[] lefts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (idx > 1 && nums[MQ[idx - 1]] >= nums[i]) {
                idx--;
            }
            lefts[i] = MQ[idx - 1];
            MQ[idx++] = i;
        }
        idx = 1;
        MQ[0] = nums.length;
        int[] arr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (idx > 1 && nums[MQ[idx - 1]] >= nums[i]) {
                idx--;
            }
            int len = MQ[idx - 1] - lefts[i] - 2;
            arr[len] = Math.max(nums[i], arr[len]);
            MQ[idx++] = i;
        }
        int[] res = new int[nums.length];
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            max = Math.max(arr[i], max);
            res[i] = max;
        }
        return res;
    }
}
