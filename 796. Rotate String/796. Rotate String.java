/*
 * Problem: 796. Rotate String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rotate-string/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        String str = new StringBuilder(s).append(s).toString();
        return str.contains(goal);
    }
}
