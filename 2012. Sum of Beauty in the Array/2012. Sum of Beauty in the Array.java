/*
 * Problem: 2012. Sum of Beauty in the Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-beauty-in-the-array/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int sumOfBeauties(int[] nums) {
        int[] lefts = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            lefts[i] = max;
            max = Math.max(max, nums[i]);
        }
        int res = 0;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            if (nums[i] > lefts[i] && nums[i] < min) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res++;
            }
            min = Math.min(min, nums[i]);
        }
        return res;
    }
}
