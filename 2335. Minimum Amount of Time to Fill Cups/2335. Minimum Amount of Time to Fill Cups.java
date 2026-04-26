/*
 * Problem: 2335. Minimum Amount of Time to Fill Cups
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int fillCups(int[] amount) {
        int max = 0;
        int sum = 0;
        for (int in : amount) {
            max = Math.max(in, max);
            sum += in;
        }
        if (2 * max <= sum) {
            return (sum+1) / 2;
        } else {
            return max;
        }
    }
}
