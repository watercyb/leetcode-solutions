/*
 * Problem: 1016. Binary String With Substrings Representing 1 To N
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public boolean queryString(String s, int n) {
        if (n >= 31000)
            return false;
        for (int i = n / 2 + 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i)))
                return false;
        }
        return true;
    }
}
