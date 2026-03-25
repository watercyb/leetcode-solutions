/*
 * Problem: 3. Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chrs = s.toCharArray();
        boolean[] seens = new boolean[256];
        int res = 0;
        int j = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (j < chrs.length && !seens[chrs[j]]) {
                seens[chrs[j]] = true;
                j++;
            }
            res = Math.max(j - i, res);
            seens[chrs[i]] = false;
        }
        return res;
    }
}
