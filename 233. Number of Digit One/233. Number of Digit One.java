/*
 * Problem: 233. Number of Digit One
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-digit-one/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public int countDigitOne(int n) {
        if (n < 1)
            return 0;
        int res = 0;
        int a = 0;
        int b = 1;
        int num = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                num += digit * b;
                if (digit == 1) {
                    res += digit * a + num - digit * b + 1;
                } else {
                    res += digit * a + b;
                }
            }
            a = a * 10 + b;
            b *= 10;
            n /= 10;
        }
        return res;
    }
}
