/*
 * Problem: 3794. Reverse String Prefix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-string-prefix/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public String reversePrefix(String s, int k) {
        return new StringBuilder(s.substring(0, k)).reverse().append(s.substring(k)).toString();
    }
}
