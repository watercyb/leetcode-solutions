/*
 * Problem: 2439. Minimize Maximum of Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-maximum-of-array/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max((sum + i) / (i + 1), res);
        }
        return (int)res;
    }
}
