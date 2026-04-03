/*
 * Problem: 434. Number of Segments in a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-segments-in-a-string/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int countSegments(String s) {
        char prv = ' ';
        int res = 0;
        for (char chr : s.toCharArray()) {
            if (chr == ' ' && prv != ' ')
                res++;
            prv = chr;
        }
        if (prv != ' ')
            res++;
        return res;
    }
}
