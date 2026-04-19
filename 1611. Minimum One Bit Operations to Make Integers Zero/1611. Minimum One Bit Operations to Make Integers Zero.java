/*
 * Problem: 1611. Minimum One Bit Operations to Make Integers Zero
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minimumOneBitOperations(int n) {
        int multiplier = 1;
        int res = 0;
        int base = 1;
        while (n > 0) {
            // res += n ^ (n - 1) * multiplier;
            // multiplier = -1 * multiplier;
            // n &= n - 1;
            if ((n & 1) == 1) {
                res += base * multiplier;
                multiplier = -1 * multiplier;
            }
            base = 2 * base + 1;
            n >>= 1;
        }
        return Math.abs(res);
    }
}
