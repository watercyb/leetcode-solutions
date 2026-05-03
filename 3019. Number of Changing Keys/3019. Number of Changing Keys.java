/*
 * Problem: 3019. Number of Changing Keys
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-changing-keys/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int countKeyChanges(String s) {
        char prv = '#';
        int res = 0;
        for (char chr : s.toCharArray()) {
            chr = Character.toLowerCase(chr);
            if (chr != prv) {
                res++;
                prv = chr;
            }
        }
        return res - 1;
    }
}
