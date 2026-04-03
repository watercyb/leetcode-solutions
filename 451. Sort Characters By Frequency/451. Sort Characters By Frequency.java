/*
 * Problem: 451. Sort Characters By Frequency
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-characters-by-frequency/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String frequencySort(String s) {
        int[][] counts = new int['z' + 1][2];
        for (int i = 0; i < counts.length; i++) {
            counts[i][1] = i;
        }
        for (char chr : s.toCharArray()) {
            counts[chr][0]++;
        }
        Arrays.sort(counts, (a, b) -> b[0] - a[0]);
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            char chr = (char) (counts[i][1]);
            for (int j = 0; j < counts[i][0]; j++) {
                SB.append(chr);
            }
        }
        return SB.toString();
    }
}
