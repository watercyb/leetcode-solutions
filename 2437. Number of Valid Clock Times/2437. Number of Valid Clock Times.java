/*
 * Problem: 2437. Number of Valid Clock Times
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-valid-clock-times/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int countTime(String time) {
        char[] chrs = time.toCharArray();
        int res = 1;
        if (chrs[0] == '?' && chrs[1] == '?') {
            res = 24;
        } else if (chrs[0] == '?') {
            if (chrs[1] < '4') {
                res = 3;
            } else {
                res = 2;
            }
        } else if (chrs[1] == '?') {
            if (chrs[0] < '2') {
                res = 10;
            } else {
                res = 4;
            }
        }
        if (chrs[3] == '?')
            res *= 6;
        if (chrs[4] == '?')
            res *= 10;
        return res;
    }
}
