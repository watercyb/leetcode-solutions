/*
 * Problem: 2734. Lexicographically Smallest String After Substring Operation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public String smallestString(String s) {
        StringBuilder SB = new StringBuilder(s);
        int l = 0;
        while (l < SB.length() && SB.charAt(l) == 'a') {
            l++;
        }
        if (l == SB.length()) {
            SB.setCharAt(SB.length() - 1, 'z');
            return SB.toString();
        }
        int r = l;
        while (r < SB.length() && SB.charAt(r) != 'a') {
            SB.setCharAt(r, (char) (SB.charAt(r) - 1));
            r++;
        }
        return SB.toString();
    }
}
