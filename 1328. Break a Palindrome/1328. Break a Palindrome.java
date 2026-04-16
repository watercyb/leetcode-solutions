/*
 * Problem: 1328. Break a Palindrome
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/break-a-palindrome/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1)
            return "";
        char[] chrs = palindrome.toCharArray();
        for (int i = 0; i < chrs.length / 2; i++) {
            if (chrs[i] != 'a') {
                chrs[i] = 'a';
                return new String(chrs);
            }
        }
        chrs[chrs.length - 1] = 'b';
        return new String(chrs);
    }
}
