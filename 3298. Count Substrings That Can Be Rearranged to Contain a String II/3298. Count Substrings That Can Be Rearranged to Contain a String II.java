/*
 * Problem: 3298. Count Substrings That Can Be Rearranged to Contain a String II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] counts = new int[26];
        for (char chr : word2.toCharArray()) {
            counts[chr - 'a']++;
        }
        int count = 0;
        for (int c : counts) {
            if (c > 0)
                count++;
        }
        int j = 0;
        char[] chrs = word1.toCharArray();
        long res = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (j < chrs.length && count > 0) {
                if (counts[chrs[j++] - 'a']-- == 1)
                    count--;
            }
            if (count > 0)
                break;
            res += chrs.length - j + 1;
            if (counts[chrs[i] - 'a']++ == 0)
                count++;
        }
        return res;
    }
}
