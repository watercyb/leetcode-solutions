/*
 * Problem: 1006. Clumsy Factorial
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/clumsy-factorial/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int clumsy(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 6;
        if (n == 4)
            return 7;
        if (n % 4 == 0)
            return n + 1;
        if (n % 4 == 1)
            return n + 2;
        if (n % 4 == 2)
            return n + 2;
        return n - 1;
    }
}
