/*
 * Problem: 1987. Number of Unique Good Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-unique-good-subsequences/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int mod = 1_000_000_007;
        long zero = 0;
        long one = 0;
        for (char chr : binary.toCharArray()) {
            if (chr == '0') {
                zero = (zero + one) % mod;
            } else {
                one = (zero + one + 1) % mod;
            }
        }
        long res = one + zero;
        if (zero > 0 || binary.charAt(0) == '0')
            res++;
        return (int) (res % mod);
    }
}
