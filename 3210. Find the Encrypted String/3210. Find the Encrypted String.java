/*
 * Problem: 3210. Find the Encrypted String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-encrypted-string/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public String getEncryptedString(String s, int k) {
        int idx = k % s.length();
        if (idx == 0)
            return s;
        return new StringBuilder(s.substring(idx)).append(s.substring(0, idx)).toString();
    }
}
