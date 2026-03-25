/*
 * Problem: 125. Valid Palindrome
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-palindrome/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean isPalindrome(String s) {
        char[] chrs = s.toCharArray();
        int l = 0;
        int r = chrs.length - 1;
        while (l < r) {
            while (l < r && chrs[l] < '0' || (chrs[l] > '9' && chrs[l] < 'A') || (chrs[l] > 'Z' && chrs[l] < 'a')
                    || chrs[l] > 'z') {
                l++;
            }
            while (l < r && chrs[r] < '0' || (chrs[r] > '9' && chrs[r] < 'A') || (chrs[r] > 'Z' && chrs[r] < 'a')
                    || chrs[r] > 'z') {
                r--;
            }
            if (chrs[l] < 'a') {
                chrs[l] += 'a' - 'A';
            }
            if (chrs[r] < 'a') {
                chrs[r] += 'a' - 'A';
            }
            if (chrs[l] != chrs[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
}
