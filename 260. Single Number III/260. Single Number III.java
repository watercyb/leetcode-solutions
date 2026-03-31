/*
 * Problem: 260. Single Number III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/single-number-iii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        int mask = a & -a;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) != 0)
                b ^= num;
        }
        return new int[] { b, a ^ b };
    }
}
