/*
 * Problem: 2697. Lexicographically Smallest Palindrome
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/lexicographically-smallest-palindrome/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chrs = s.toCharArray();
        int i = 0;
        int j = chrs.length - 1;
        while (i < j) {
            if (chrs[i] != chrs[j])
                chrs[i] = chrs[j] = (char) Math.min(chrs[i], chrs[j]);
            i++;
            j--;
        }
        return new String(chrs);
    }
}
