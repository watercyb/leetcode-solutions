/*
 * Problem: 503. Next Greater Element II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/next-greater-element-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] MQ = new int[nums.length];
        int idx = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (idx > 0 && MQ[idx - 1] <= nums[i]) {
                idx--;
            }
            MQ[idx++] = nums[i];
        }
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (idx > 0 && MQ[idx - 1] <= nums[i]) {
                idx--;
            }
            if (idx > 0) {
                res[i] = MQ[idx - 1];
            } else {
                res[i] = -1;
            }
            MQ[idx++] = nums[i];
        }
        return res;
    }
}
