/*
 * Problem: 2136. Earliest Possible Day of Full Bloom
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[] counts = new int[10001];
        for (int i = 0; i < plantTime.length; i++) {
            counts[growTime[i]] += plantTime[i];
        }
        int res = 0;
        int sum = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] > 0) {
                sum += counts[i];
                res = Math.max(sum + i, res);
            }
        }
        return res;
    }
}
