/*
 * Problem: 3662. Filter Characters by Frequency
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/filter-characters-by-frequency/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public String filterCharacters(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        for (char chr : chrs) {
            counts[chr]++;
        }
        StringBuilder SB = new StringBuilder();
        for (char chr : chrs) {
            if (counts[chr] > 0 && counts[chr] < k)
                SB.append(chr);
        }
        return SB.toString();
    }
}
