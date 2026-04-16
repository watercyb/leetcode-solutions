/*
 * Problem: 1317. Convert Integer to the Sum of Two No-Zero Integers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (chk(i) && chk(n - i))
                return new int[] { i, n - i };
        }
        return new int[0];
    }

    public boolean chk(int n) {
        while (n > 0) {
            if (n % 10 == 0)
                return false;
            n /= 10;
        }
        return true;
    }
}
