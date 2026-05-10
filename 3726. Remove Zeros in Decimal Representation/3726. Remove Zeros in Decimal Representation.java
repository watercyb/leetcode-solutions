/*
 * Problem: 3726. Remove Zeros in Decimal Representation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-zeros-in-decimal-representation/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long removeZeros(long n) {
        long base = 1;
        long res = 0;
        while (n > 0) {
            if (n % 10 != 0) {
                res += base * (n % 10);
                base *= 10;
            }
            n /= 10;
        }
        return res;
    }
}
