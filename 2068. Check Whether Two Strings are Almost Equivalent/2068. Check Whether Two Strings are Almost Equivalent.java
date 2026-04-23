/*
 * Problem: 2068. Check Whether Two Strings are Almost Equivalent
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] counts = new int[26];
        for (char chr : word1.toCharArray()) {
            counts[chr - 'a']++;
        }
        for (char chr : word2.toCharArray()) {
            counts[chr - 'a']--;
        }
        for (int count : counts) {
            if (Math.abs(count) > 3)
                return false;
        }
        return true;
    }
}
