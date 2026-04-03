/*
 * Problem: 479. Largest Palindrome Product
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/largest-palindrome-product/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int largestPalindrome(int n) {
        long max = (long) Math.pow(10, n) - 1;
        long min = max / 10 + 1;

        for (long i = max; i >= min; i--) {
            long num1 = i;
            long num2 = i;
            while (num2 > 0) {
                num1 = num1 * 10 + num2 % 10;
                num2 /= 10;
            }
            for (long j = max; j * j >= num1; j--) {
                if (num1 % j == 0)
                    return (int) (num1 % 1337);
            }
        }
        return 9;
    }
}
