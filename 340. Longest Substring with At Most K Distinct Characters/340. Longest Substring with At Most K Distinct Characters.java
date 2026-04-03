/*
 * Problem: 340. Longest Substring with At Most K Distinct Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[128];
        int dist = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            counts[chrs[i]]++;
            if (counts[chrs[i]] == 1)
                dist++;
            while (dist > k) {
                counts[chrs[j]]--;
                if (counts[chrs[j]] == 0)
                    dist--;
                j++;
            }
            res = Math.max(i - j + 1, res);
        }
        return res;
    }
}
