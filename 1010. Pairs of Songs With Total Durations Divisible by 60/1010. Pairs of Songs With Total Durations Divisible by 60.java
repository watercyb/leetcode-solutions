/*
 * Problem: 1010. Pairs of Songs With Total Durations Divisible by 60
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] counts = new int[60];
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            int mod = time[i] % 60;
            res += counts[(60 - mod) % 60];
            counts[mod]++;
        }
        return res;
    }
}
