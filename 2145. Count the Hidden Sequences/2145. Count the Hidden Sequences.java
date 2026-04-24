/*
 * Problem: 2145. Count the Hidden Sequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-hidden-sequences/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long max = 0;
        long min = 0;
        long num = 0;
        for (int diff : differences) {
            num += diff;
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return (int) Math.max((long) upper - lower - max + min + 1, 0);
    }
}
