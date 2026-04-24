/*
 * Problem: 2131. Longest Palindrome by Concatenating Two Letter Words
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int longestPalindrome(String[] words) {
        int[] counts = new int[26 * 26];
        int res = 0;
        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            int idx = b * 26 + a;
            if (counts[idx] > 0) {
                res += 4;
                counts[idx]--;
            } else {
                counts[a * 26 + b]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i * 26 + i] > 0)
                return res + 2;
        }
        return res;
    }
}
