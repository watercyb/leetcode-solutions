/*
 * Problem: 14. Longest Common Prefix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-common-prefix/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char stp = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() == i || str.charAt(i) != stp)
                    return SB.toString();
            }
            SB.append(stp);
        }
        return SB.toString();
    }
}
