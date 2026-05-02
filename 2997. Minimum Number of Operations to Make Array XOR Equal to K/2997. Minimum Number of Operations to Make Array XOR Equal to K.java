/*
 * Problem: 2997. Minimum Number of Operations to Make Array XOR Equal to K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int minOperations(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            k ^= nums[i];
        }
        return Integer.bitCount(k);
    }
}
