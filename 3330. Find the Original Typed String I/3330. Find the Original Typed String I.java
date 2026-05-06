/*
 * Problem: 3330. Find the Original Typed String I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-original-typed-string-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int possibleStringCount(String word) {
        int res = 1;
        char prv = '#';
        for (char chr : word.toCharArray()) {
            if (chr == prv) {
                res++;
            } else {
                prv = chr;
            }
        }
        return res;
    }
}
