/*
 * Problem: 400. Nth Digit
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/nth-digit/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findNthDigit(int n) {
        int num = 1;
        int digit = 1;
        while (n > 0) {
            long tmp = 9l * num * digit;
            if (n <= tmp)
                break;
            num *= 10;
            digit++;
            n -= tmp;
        }
        num += (n - 1) / digit;
        n = digit - (n - 1) % digit - 1;
        for (int i = 0; i < n; i++) {
            num /= 10;
        }
        return num % 10;
    }
}
