/*
 * Problem: 796. Rotate String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rotate-string/?envType=daily-question&envId=2026-05-03
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        String str = new StringBuilder(s).append(s).toString();
        return str.contains(goal);
    }
}
