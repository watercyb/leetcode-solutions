/*
 * Problem: 258. Add Digits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/add-digits/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
