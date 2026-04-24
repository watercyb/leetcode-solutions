/*
 * Problem: 2193. Minimum Number of Moves to Make Palindrome
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minMovesToMakePalindrome(String s) {
        StringBuilder SB = new StringBuilder(s);
        int res = 0;
        while (SB.length() > 0) {
            int idx = SB.indexOf(String.valueOf(SB.charAt(SB.length() - 1)));
            if (idx == SB.length() - 1) {
                res += idx / 2;
            } else {
                res += idx;
                SB.deleteCharAt(idx);
            }
            SB.deleteCharAt(SB.length() - 1);
        }
        return res;
    }
}
