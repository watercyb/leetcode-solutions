/*
 * Problem: 3837. Delayed Count of Equal Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delayed-count-of-equal-elements/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int[] delayedCount(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] counts = new int[max + 1];
        int[] res = new int[nums.length];
        for (int i = nums.length - k - 2; i >= 0; i--) {
            counts[nums[i + k + 1]]++;
            res[i] = counts[nums[i]];
        }
        return res;
    }
}
