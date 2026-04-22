/*
 * Problem: 1941. Check if All Characters Have Equal Number of Occurrences
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int target = -1;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] == 0)
                continue;
            if (target == -1) {
                target = counts[i];
            } else if (target != counts[i]) {
                return false;
            }
        }
        return true;
    }
}
