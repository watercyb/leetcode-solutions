/*
 * Problem: 567. Permutation in String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/permutation-in-string/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] counts = new int['z' + 1];
        int dist = 0;
        for (char chr : s1.toCharArray()) {
            counts[chr]++;
            if (counts[chr] == 1)
                dist++;
        }
        char[] chrs = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            counts[chrs[i]]--;
            if (counts[chrs[i]] == 0) {
                dist--;
            } else if (counts[chrs[i]] == -1) {
                dist++;
            }
        }
        if (dist == 0)
            return true;
        int j = 0;
        for (int i = s1.length(); i < chrs.length; i++) {
            counts[chrs[i]]--;
            if (counts[chrs[i]] == 0) {
                dist--;
            } else if (counts[chrs[i]] == -1) {
                dist++;
            }
            if (counts[chrs[j]] == 0) {
                dist++;
            } else if (counts[chrs[j]] == -1) {
                dist--;
            }
            counts[chrs[j++]]++;
            if (dist == 0)
                return true;
        }
        return false;
    }
}
