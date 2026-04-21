/*
 * Problem: 1829. Maximum XOR for Each Query
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-xor-for-each-query/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        res[nums.length - 1] = nums[0] ^ ((1 << maximumBit) - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i + 1] ^ nums[nums.length - 1 - i];
        }
        return res;
    }
}
