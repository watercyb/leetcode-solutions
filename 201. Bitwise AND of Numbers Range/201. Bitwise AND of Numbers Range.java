/*
 * Problem: 201. Bitwise AND of Numbers Range
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }
} 
