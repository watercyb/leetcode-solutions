/*
 * Problem: 3754. Concatenate Non-Zero Digits and Multiply by Sum I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/?envType=daily-question&envId=2026-07-07
 * Language: java
 * Date: 2026-07-07
 */

class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        int sum = 0;
        int base = 1;
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                num += digit * base;
                sum += digit;
                base *= 10;
            }
            n /= 10;
        }
        return num * sum;
    }
}
