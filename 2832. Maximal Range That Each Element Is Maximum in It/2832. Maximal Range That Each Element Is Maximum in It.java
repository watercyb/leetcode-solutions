/*
 * Problem: 2832. Maximal Range That Each Element Is Maximum in It
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximal-range-that-each-element-is-maximum-in-it/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        int[] left = new int[nums.length];
        int[] MQ = new int[nums.length + 1];
        MQ[0] = -1;
        int idx = 1;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 1 && nums[MQ[idx - 1]] < nums[i]) {
                idx--;
            }
            left[i] = MQ[idx - 1];
            MQ[idx++] = i;
        }
        MQ[0] = nums.length;
        idx = 1;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (idx > 1 && nums[MQ[idx - 1]] < nums[i]) {
                idx--;
            }
            res[i] = MQ[idx - 1] - left[i] - 1;
            MQ[idx++] = i;
        }
        return res;
    }
}
