/*
 * Problem: 3816. Lexicographically Smallest String After Deleting Duplicate Characters
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/lexicographically-smallest-string-after-deleting-duplicate-characters/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public String lexSmallestAfterDeletion(String s) {
        char[] chrs = s.toCharArray();
        int[] rights = new int[26];
        for (char chr : chrs) {
            rights[chr - 'a']++;
        }
        int[] lefts = new int[26];
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (idx > 0 && chrs[idx - 1] > chrs[i] && lefts[chrs[idx - 1] - 'a'] + rights[chrs[idx - 1] - 'a'] > 1) {
                lefts[chrs[idx - 1] - 'a']--;
                idx--;
            }
            chrs[idx++] = chrs[i];
            lefts[chrs[i] - 'a']++;
            rights[chrs[i] - 'a']--;
        }
        while (lefts[chrs[idx - 1] - 'a'] > 1) {
            lefts[chrs[idx - 1] - 'a']--;
            idx--;
        }
        return new String(chrs, 0, idx);
    }
}
