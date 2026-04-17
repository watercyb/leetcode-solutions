/*
 * Problem: 1427. Perform String Shifts
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/perform-string-shifts/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public String stringShift(String s, int[][] shift) {
        int l = s.length();
        int n = 0;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                n -= shift[i][1];
            } else {
                n += shift[i][1];
            }
        }
        n %= l;
        if (n < 0)
            n += l;
        return s.substring(l - n) + s.substring(0, l - n);
    }
}
