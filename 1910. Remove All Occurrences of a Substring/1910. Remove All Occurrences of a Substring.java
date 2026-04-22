/*
 * Problem: 1910. Remove All Occurrences of a Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder SB = new StringBuilder(s);
        int idx = SB.indexOf(part);
        while (idx >= 0) {
            SB.delete(idx, idx + part.length());
            idx = SB.indexOf(part);
        }
        return SB.toString();
    }
}
