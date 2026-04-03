/*
 * Problem: 392. Is Subsequence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/is-subsequence/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        int i = 0;
        for (char chr : s.toCharArray()) {
            while (i < t.length() && t.charAt(i) != chr) {
                i++;
            }
            if (i == t.length())
                return false;
            i++;
        }
        return true;
    }
}
