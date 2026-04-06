/*
 * Problem: 3889. Mirror Frequency Distance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/mirror-frequency-distance/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int mirrorFrequency(String s) {
        int[] counts = new int[128];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int res = 0;
        int l = 'a';
        int r = 'z';
        while (l < r) {
            res += Math.abs(counts[l] - counts[r]);
            l++;
            r--;
        }
        l = '0';
        r = '9';
        while (l < r) {
            res += Math.abs(counts[l] - counts[r]);
            l++;
            r--;
        }
        return res;
    }
}
