/*
 * Problem: 1732. Find the Highest Altitude
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-highest-altitude/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int sum = 0;
        for (int alt : gain) {
            sum += alt;
            res = Math.max(sum, res);
        }
        return res;
    }
}
