/*
 * Problem: 344. Reverse String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-string/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
