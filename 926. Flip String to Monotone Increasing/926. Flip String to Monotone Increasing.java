/*
 * Problem: 926. Flip String to Monotone Increasing
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flip-string-to-monotone-increasing/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minFlipsMonoIncr(String s) {
        int a = 0;
        int b = 0;
        for (char chr : s.toCharArray()) {
            if (chr == '0') {
                b++;
            } else {
                b = Math.min(b, a);
                a++;
            }
        }
        return Math.min(a, b);
    }
}
