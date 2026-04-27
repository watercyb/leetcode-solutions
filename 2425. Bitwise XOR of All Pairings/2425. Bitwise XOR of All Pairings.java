/*
 * Problem: 2425. Bitwise XOR of All Pairings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bitwise-xor-of-all-pairings/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;
        if (nums2.length % 2 == 1) {
            for (int num : nums1) {
                res ^= num;
            }
        }
        if (nums1.length % 2 == 1) {
            for (int num : nums2) {
                res ^= num;
            }
        }
        return res;
    }
}
