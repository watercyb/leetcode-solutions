/*
 * Problem: 151. Reverse Words in a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-words-in-a-string/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ", 0);
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].length() != 0) {
                res.append(strs[i]);
                res.append(' ');
            }
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }
}
