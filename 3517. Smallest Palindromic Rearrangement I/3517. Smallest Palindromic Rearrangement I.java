/*
 * Problem: 3517. Smallest Palindromic Rearrangement I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public String smallestPalindrome(String s) {
        char[] res = new char[s.length()];
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int l = 0;
        int r = res.length - 1;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] % 2 == 1)
                res[res.length / 2] = (char) i;
            for (int j = 0; j < counts[i] / 2; j++) {
                res[l++] = (char) i;
                res[r--] = (char) i;
            }
        }
        return new String(res);
    }
}
