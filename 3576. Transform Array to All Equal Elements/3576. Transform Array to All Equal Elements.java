/*
 * Problem: 3576. Transform Array to All Equal Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/transform-array-to-all-equal-elements/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int next1 = 1;
        int next2 = 1;
        int k1 = k;
        int k2 = k;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] * next1 != 1) {
                next1 = -1;
                k1--;
            } else {
                next1 = 1;
            }
            if (nums[i] * next2 != -1) {
                next2 = -1;
                k2--;
            } else {
                next2 = 1;
            }
        }
        return (k1 >= 0 && nums[nums.length - 1] * next1 == 1) || (k2 >= 0 && nums[nums.length - 1] * next2 == -1);
    }
}
