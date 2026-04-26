/*
 * Problem: 2330. Valid Palindrome IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-palindrome-iv/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public boolean makePalindrome(String s) {
        char[] chrs = s.toCharArray();
        int count = 0;
        int l = 0;
        int r = chrs.length - 1;
        while (l < r) {
            if (chrs[l] != chrs[r]) {
                count++;
                if (count > 2)
                    return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
