/*
 * Problem: 159. Longest Substring with At Most Two Distinct Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        int diff = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (counts[chrs[i]]++ == 0)
                diff++;
            while (diff == 3) {
                if (counts[chrs[j]]-- == 1)
                    diff--;
                j++;
            }
            res = Math.max(i - j, res);
        }
        return res + 1;
    }
}
