/*
 * Problem: 806. Number of Lines To Write String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-lines-to-write-string/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int a = 1;
        int b = 0;
        for (char chr : s.toCharArray()) {
            if (b + widths[chr - 'a'] > 100) {
                a++;
                b = widths[chr - 'a'];
            } else {
                b += widths[chr - 'a'];
            }
        }
        return new int[] { a, b };
    }
}
