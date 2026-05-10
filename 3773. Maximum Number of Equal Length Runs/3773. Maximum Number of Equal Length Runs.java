/*
 * Problem: 3773. Maximum Number of Equal Length Runs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-equal-length-runs/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int maxSameLengthRuns(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[chrs.length + 1];
        char prv = '#';
        int len = 0;
        for (char chr : chrs) {
            if (chr != prv) {
                counts[len]++;
                len = 1;
                prv = chr;
            } else {
                len++;
            }
        }
        counts[len]++;
        int res = 0;
        for (int count : counts) {
            res = Math.max(res, count);
        }
        return res;
    }
}
