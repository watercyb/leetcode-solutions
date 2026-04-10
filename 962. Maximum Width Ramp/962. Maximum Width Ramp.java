/*
 * Problem: 962. Maximum Width Ramp
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-width-ramp/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] left = new int[nums.length];
        int l = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[left[l - 1]])
                left[l++] = i;
        }
        int res = 0;
        int i = nums.length - 1;
        for (int j = l - 1; j >= 0; j--) {
            while (i > j && nums[i] < nums[left[j]]) {
                i--;
            }
            res = Math.max(i - left[j], res);
            if (i <= res)
                break;
        }
        return res;
    }
}
