/*
 * Problem: 1653. Minimum Deletions to Make String Balanced
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minimumDeletions(String s) {
        int a = 0;
        int b = 0;
        for (char chr : s.toCharArray()) {
            if (chr == 'a') {
                b++;
            } else {
                if (a < b)
                    b = a;
                a++;
            }
        }
        return Math.min(a, b);
    }
}
