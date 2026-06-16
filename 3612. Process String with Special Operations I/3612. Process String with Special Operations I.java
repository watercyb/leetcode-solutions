/*
 * Problem: 3612. Process String with Special Operations I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/process-string-with-special-operations-i/?envType=daily-question&envId=2026-06-16
 * Language: java
 * Date: 2026-06-16
 */

class Solution {
    public String processStr(String s) {
        StringBuilder SB = new StringBuilder();
        for (char chr : s.toCharArray()) {
            if (chr == '*') {
                if (SB.length() > 0)
                    SB.setLength(SB.length() - 1);
            } else if (chr == '#') {
                SB.append(SB.toString());
            } else if (chr == '%') {
                SB.reverse();
            } else {
                SB.append(chr);
            }
        }
        return SB.toString();
    }
}
