/*
 * Problem: 1717. Maximum Score From Removing Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-score-from-removing-substrings/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maximumGain(String s, int x, int y) {
        char a = 'a';
        char b = 'b';
        if (y > x) {
            a = 'b';
            b = 'a';
            int tmp = x;
            x = y;
            y = tmp;
        }
        int res = 0;
        int count = 0;
        int remain = 0;
        for (char chr : s.toCharArray()) {
            if (chr == a) {
                count++;
            } else if (chr == b) {
                if (count > 0) {
                    count--;
                    res += x;
                } else {
                    remain++;
                }
            } else {
                res += y * Math.min(count, remain);
                count = 0;
                remain = 0;
            }
        }
        return res + y * Math.min(count, remain);
    }
}
