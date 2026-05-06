/*
 * Problem: 3379. Transformed Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/transformed-array/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[((i + nums[i]) % nums.length + nums.length) % nums.length];
        }
        return res;
    }
}
