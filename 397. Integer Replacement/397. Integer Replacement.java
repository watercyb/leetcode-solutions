/*
 * Problem: 397. Integer Replacement
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/integer-replacement/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int integerReplacement(int n) {
        int res = 0;
        long num = n;
        while (num > 1) {
            if (num % 2 == 1) {
                if (num == 3)
                    return res + 2;
                if ((num & 2) != 0)
                    num++;
                res++;
            }
            res++;
            num /= 2;
        }
        return res;
    }
}
