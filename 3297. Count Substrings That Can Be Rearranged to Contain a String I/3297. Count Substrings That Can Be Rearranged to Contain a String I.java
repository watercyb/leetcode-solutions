/*
 * Problem: 3297. Count Substrings That Can Be Rearranged to Contain a String I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long validSubstringCount(String word1, String word2) {
        char[] strs1 = word1.toCharArray();
        char[] strs2 = word2.toCharArray();
        int[] counts = new int[26];
        int count = 0;
        for (int i = 0; i < strs2.length; i++) {
            if (counts[strs2[i] - 'a']++ == 0)
                count++;
        }
        long res = 0;
        int j = 0;
        for (int i = 0; i < strs1.length; i++) {
            while (j < strs1.length && count > 0) {
                if (counts[strs1[j] - 'a']-- == 1)
                    count--;
                j++;
            }
            if (count > 0)
                break;
            res += strs1.length - j + 1;
            if (counts[strs1[i] - 'a']++ == 0)
                count++;
        }
        return res;
    }
}
