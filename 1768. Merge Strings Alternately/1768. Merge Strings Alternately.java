/*
 * Problem: 1768. Merge Strings Alternately
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-strings-alternately/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int l = Math.min(word1.length(), word2.length());
        for (int i = 0; i < l; i++) {
            res.append(word1.charAt(i)).append(word2.charAt(i));
        }
        return res.append(word1.substring(l)).append(word2.substring(l)).toString();
    }
}
