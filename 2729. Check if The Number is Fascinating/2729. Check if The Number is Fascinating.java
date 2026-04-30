/*
 * Problem: 2729. Check if The Number is Fascinating
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-the-number-is-fascinating/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public boolean isFascinating(int n) {
        boolean[] useds = new boolean[10];
        useds[0] = true;
        return chk(useds, n) && chk(useds, 2 * n) && chk(useds, 3 * n);
    }

    public boolean chk(boolean[] useds, int num) {
        while (num > 0) {
            if (useds[num % 10])
                return false;
            useds[num % 10] = true;
            num /= 10;
        }
        return true;
    }
}
