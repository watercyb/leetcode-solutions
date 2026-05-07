/*
 * Problem: 3442. Maximum Difference Between Even and Odd Frequency I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxDifference(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int chr = s.charAt(i) - 'a';
            counts[chr]++;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0)
                continue;
            if ((counts[i] & 1) == 1) {
                max = Math.max(counts[i], max);
            } else {
                min = Math.min(counts[i], min);
            }
        }
        return max - min;
    }
}
