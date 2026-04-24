/*
 * Problem: 2116. Check if a Parentheses String Can Be Valid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1)
            return false;
        char[] chrsL = locked.toCharArray();
        int changable = 0;
        int p = 0;
        int count = 0;
        for (int i = 0; i < chrsL.length; i++) {
            if (s.charAt(i) == '(') {
                p++;
                if (chrsL[i] == '0') {
                    if (--count < 0)
                        count = 0;
                } else {
                    count++;
                }
            } else {
                if (chrsL[i] == '0')
                    changable++;
                if (p == 0) {
                    if (changable == 0)
                        return false;
                    changable--;
                    p++;
                } else {
                    p--;
                }
                if (--count < 0)
                    count = 0;
            }
        }
        return count == 0;
    }
}
