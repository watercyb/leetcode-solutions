/*
 * Problem: 3688. Bitwise OR of Even Numbers in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/bitwise-or-of-even-numbers-in-an-array/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                res |= num;
        }
        return res;
    }
}
