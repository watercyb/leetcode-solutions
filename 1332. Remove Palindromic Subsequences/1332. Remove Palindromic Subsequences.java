/*
 * Problem: 1332. Remove Palindromic Subsequences
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-palindromic-subsequences/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int removePalindromeSub(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j)
            return 1;
        return 2;
    }
}
