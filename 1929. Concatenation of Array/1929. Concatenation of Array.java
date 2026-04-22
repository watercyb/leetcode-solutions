/*
 * Problem: 1929. Concatenation of Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/concatenation-of-array/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[2 * nums.length];
        System.arraycopy(nums, 0, res, 0, nums.length);
        System.arraycopy(nums, 0, res, nums.length, nums.length);
        return res;
    }
}
