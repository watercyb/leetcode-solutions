/*
 * Problem: 1330. Reverse Subarray To Maximize Array Value
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/reverse-subarray-to-maximize-array-value/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int max = Integer.MIN_VALUE / 3;
        int min = Integer.MAX_VALUE / 3;
        int sum = 0;
        int maxDiff = 0;
        int l = nums[0];
        int r = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            maxDiff = Math.max(maxDiff,
                    Math.max(Math.abs(nums[i] - l), Math.abs(nums[i - 1] - r)) - Math.abs(nums[i] - nums[i - 1]));
        }
        for (int i = 1; i < nums.length; i++) {
            int max_num = Math.max(nums[i - 1], nums[i]);
            int min_num = Math.min(nums[i - 1], nums[i]);
            max = Math.max(max, min_num);
            min = Math.min(min, max_num);
            sum += max_num - min_num;
        }
        return sum + Math.max(maxDiff, (max - min) * 2);
    }
}

