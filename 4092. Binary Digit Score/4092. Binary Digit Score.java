/*
 * Problem: 4092. Binary Digit Score
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-digit-score/
 * Language: java
 * Date: 2026-10-28
 */

class Solution {
    public int calculateScore(int a, int b) {
        int s1 = Integer.bitCount(a);
        int s2 = Integer.bitCount(b);
        if (s1 >= s2) {
            return s1 * s2;
        } else {
            return s2 / s1;
        }
    }
}
