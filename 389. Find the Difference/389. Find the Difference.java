/*
 * Problem: 389. Find the Difference
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-difference/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public char findTheDifference(String s, String t) {
        int[] counts = new int['z' + 1];
        for (char chr:s.toCharArray()) {
            counts[chr]++;
        }
        for (char chr:t.toCharArray()) {
            counts[chr]--;
            if (counts[chr]==-1) return chr;
        }
        return ' ';
    }
}
