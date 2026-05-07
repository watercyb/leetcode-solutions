/*
 * Problem: 3407. Substring Matching Pattern
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/substring-matching-pattern/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public boolean hasMatch(String s, String p) {
        int idx = p.indexOf('*');
        String a = p.substring(0, idx);
        String b = p.substring(idx + 1, p.length());
        idx = s.indexOf(a);
        if (idx == -1)
            return false;
        return s.indexOf(b, idx + a.length()) >= 0;
    }
}
