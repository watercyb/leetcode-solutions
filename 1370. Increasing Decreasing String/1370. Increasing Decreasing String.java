/*
 * Problem: 1370. Increasing Decreasing String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/increasing-decreasing-string/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public String sortString(String s) {
        StringBuilder SB = new StringBuilder();
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int prv = -1;
        while (prv != SB.length()) {
            prv = SB.length();
            for (int i = 'a'; i <= 'z'; i++) {
                if (counts[i] > 0) {
                    counts[i]--;
                    SB.append((char) i);
                }
            }
            for (int i = 'z'; i >= 'a'; i--) {
                if (counts[i] > 0) {
                    counts[i]--;
                    SB.append((char) i);
                }
            }
        }
        return SB.toString();
    }
}
