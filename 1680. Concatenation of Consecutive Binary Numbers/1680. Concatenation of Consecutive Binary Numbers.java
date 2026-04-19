/*
 * Problem: 1680. Concatenation of Consecutive Binary Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1_000_000_007;
        long res = 0;
        int base = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0)
                base++;
            res = ((res << base) + i) % mod;
        }
        return (int) res;
    }
}
