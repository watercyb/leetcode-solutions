/*
 * Problem: 1813. Sentence Similarity III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sentence-similarity-iii/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] strs1 = sentence1.split(" ");
        String[] strs2 = sentence2.split(" ");
        if (strs1.length < strs2.length) {
            String[] tempStrs = strs1;
            strs1 = strs2;
            strs2 = tempStrs;
        }
        int l = 0;
        int r1 = strs1.length - 1;
        int r2 = strs2.length - 1;
        while (l <= r2 && strs1[l].equals(strs2[l])) {
            l++;
        }
        while (l <= r2 && strs1[r1].equals(strs2[r2])) {
            r1--;
            r2--;
        }
        return l > r2;
    }
}
