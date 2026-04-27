/*
 * Problem: 2486. Append Characters to String to Make Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int appendCharacters(String s, String t) {
        int idx = 0;
        char[] chrs = t.toCharArray();
        for (char chr : s.toCharArray()) {
            if (chr == chrs[idx]) {
                idx++;
                if (idx == chrs.length)
                    return 0;
            }
        }
        return t.length() - idx;
    }
}
