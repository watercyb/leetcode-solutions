/*
 * Problem: 409. Longest Palindrome
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-palindrome/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int res = 0;
        boolean odd = false;
        for (int i = 'A'; i <= 'z'; i++) {
            if (counts[i] % 2 == 1) {
                res += counts[i] - 1;
                odd = true;
            } else {
                res += counts[i];
            }
        }
        if (odd)
            res++;
        return res;
    }
}
