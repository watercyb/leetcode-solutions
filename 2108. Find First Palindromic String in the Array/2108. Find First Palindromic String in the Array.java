/*
 * Problem: 2108. Find First Palindromic String in the Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public String firstPalindrome(String[] words) {
        for (String word:words) {
            int l=0;
            int r=word.length()-1;
            while (word.charAt(l)==word.charAt(r)) {
                l++;
                r--;
                if (l>=r) return word;
            }
        }
        return "";
    }
}
