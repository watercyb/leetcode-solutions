/*
 * Problem: 1541. Minimum Insertions to Balance a Parentheses String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minInsertions(String s) {
        int n = 0;
        int res = 0;
        for (char chr:s.toCharArray()) {
            if (chr == '(') {
                if (n % 2 == 1) {
                    res++;
                    n--;
                }
                n += 2;
            } else {
                n--;
                if (n < 0) {
                    res++;
                    n += 2;
                }
            }
        }
        return res + n;
    }
}
