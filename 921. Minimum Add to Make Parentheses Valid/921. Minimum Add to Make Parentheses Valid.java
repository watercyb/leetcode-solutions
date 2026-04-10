/*
 * Problem: 921. Minimum Add to Make Parentheses Valid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int count = 0;
        for (char chr : s.toCharArray()) {
            if (chr == '(') {
                count++;
            } else if (count == 0) {
                res++;
            } else {
                count--;
            }
        }
        return res + count;
    }
}
