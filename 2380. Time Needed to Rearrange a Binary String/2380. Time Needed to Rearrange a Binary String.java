/*
 * Problem: 2380. Time Needed to Rearrange a Binary String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int res = 0;
        int count = 0;
        for (char chr : s.toCharArray()) {
            if (chr == '0') {
                count++;
            } else if (count > 0) {
                res = Math.max(res + 1, count);
            }
        }
        return res;
    }
}
