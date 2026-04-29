/*
 * Problem: 2609. Find the Longest Balanced Substring of a Binary String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) == '0') {
                    j++;
                }
                if (j == s.length())
                    break;
                int k = j + 1;
                while (k < s.length() && k - j < j - i && s.charAt(k) == '1') {
                    k++;
                }
                res = Math.max(k - j, res);
                i = k;
            } else {
                i++;
            }
        }
        return res * 2;
    }
}
