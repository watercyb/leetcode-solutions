/*
 * Problem: 1009. Complement of Base 10 Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/complement-of-base-10-integer/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int bitwiseComplement(int n) {
        int mask = 1 << ((int) (Math.log(n) / Math.log(2)) + 1);
        return n ^ (mask - 1);
    }
}
