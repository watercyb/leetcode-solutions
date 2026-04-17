/*
 * Problem: 1446. Consecutive Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/consecutive-characters/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int maxPower(String s) {
        char prv = '0';
        int count = 0;
        int res = 0;
        for (char chr : s.toCharArray()) {
            if (chr != prv) {
                res = Math.max(count, res);
                count = 1;
                prv = chr;
            } else {
                count++;
            }
        }
        return Math.max(res, count);
    }
}
