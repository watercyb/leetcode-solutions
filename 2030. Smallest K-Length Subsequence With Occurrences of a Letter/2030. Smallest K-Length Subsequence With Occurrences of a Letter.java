/*
 * Problem: 2030. Smallest K-Length Subsequence With Occurrences of a Letter
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        char[] chrs = s.toCharArray();
        int count = 0;
        for (char chr : chrs) {
            if (chr == letter)
                count++;
        }
        char[] MQ = new char[chrs.length];
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (idx > 0 && chrs[i] < MQ[idx - 1] && idx + chrs.length - i > k) {
                if (MQ[idx - 1] == letter) {
                    if (count == repetition)
                        break;
                    count--;
                }
                idx--;
            }
            MQ[idx++] = chrs[i];
        }
        int length = idx;
        idx--;
        while (length > k) {
            if (MQ[idx] == letter && count > repetition) {
                MQ[idx] = '@';
                count--;
                length--;
            } else if (MQ[idx] != letter) {
                MQ[idx] = '@';
                length--;
            }
            idx--;
        }
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < chrs.length && length > 0; i++) {
            if (MQ[i] != '@') {
                SB.append(MQ[i]);
                length--;
            }
        }
        return SB.toString();
    }
}
