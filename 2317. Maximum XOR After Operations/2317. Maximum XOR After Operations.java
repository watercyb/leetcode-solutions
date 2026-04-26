/*
 * Problem: 2317. Maximum XOR After Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-xor-after-operations/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int maximumXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res |= num;
        }
        return res;
    }
}
