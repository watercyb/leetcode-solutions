/*
 * Problem: 136. Single Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/single-number/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
