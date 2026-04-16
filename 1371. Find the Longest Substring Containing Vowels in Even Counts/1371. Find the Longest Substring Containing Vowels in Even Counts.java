/*
 * Problem: 1371. Find the Longest Substring Containing Vowels in Even Counts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int findTheLongestSubstring(String s) {
        char[] chrs = s.toCharArray();
        int[] masks = new int['z' + 1];
        masks['a'] = 1;
        masks['e'] = 2;
        masks['i'] = 4;
        masks['o'] = 8;
        masks['u'] = 16;
        int[] meme = new int[32];
        Arrays.fill(meme, Integer.MAX_VALUE);
        int h = 0;
        meme[0] = -1;
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            h ^= masks[chrs[i]];
            if (meme[h] != Integer.MAX_VALUE) {
                res = Math.max(i - meme[h], res);
            } else {
                meme[h] = i;
            }
        }
        return res;
    }
}
