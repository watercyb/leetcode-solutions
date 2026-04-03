/*
 * Problem: 476. Number Complement
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-complement/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findComplement(int num) {
        int mask = 1 << ((int) (Math.log(num) / Math.log(2)) + 1);
        return num ^ (mask - 1);
    }
}
