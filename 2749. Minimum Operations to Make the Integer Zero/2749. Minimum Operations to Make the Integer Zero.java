/*
 * Problem: 2749. Minimum Operations to Make the Integer Zero
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int i = 1;
        long num = num1;
        while (num > 0) {
            num -= num2;
            if (Long.bitCount(num) <= i && num >= i)
                return i;
            i++;
        }
        return -1;
    }
}
