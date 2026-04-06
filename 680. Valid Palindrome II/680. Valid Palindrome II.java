/*
 * Problem: 680. Valid Palindrome II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-palindrome-ii/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return chk(s, l + 1, r) || chk(s, l, r - 1);
            l++;
            r--;
        }
        return true;
    }

    public boolean chk(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
