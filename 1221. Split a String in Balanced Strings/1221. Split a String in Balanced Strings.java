/*
 * Problem: 1221. Split a String in Balanced Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (char chr : s.toCharArray()) {
            if (chr == 'R') {
                count--;
            } else {
                count++;
            }
            if (count == 0)
                res++;
        }
        return res;
    }
}
