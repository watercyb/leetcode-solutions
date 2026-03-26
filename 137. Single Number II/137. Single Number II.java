/*
 * Problem: 137. Single Number II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/single-number-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int aNext = (a & (~num)) | ((~a) & (num) & (~b));
            int bNext = (a & (num)) | (b & (~num));
            a = aNext;
            b = bNext;
        }
        return a;
    }
}
