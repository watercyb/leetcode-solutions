/*
 * Problem: 3798. Largest Even Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-even-number/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public String largestEven(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '2')
                return s.substring(0, i + 1);
        }
        return "";
    }
}
