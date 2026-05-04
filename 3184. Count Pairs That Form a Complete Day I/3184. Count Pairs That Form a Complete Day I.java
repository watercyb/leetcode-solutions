/*
 * Problem: 3184. Count Pairs That Form a Complete Day I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int[] counts = new int[24];
        int res = 0;
        for (int hour : hours) {
            hour = hour % 24;
            res += counts[(24 - hour) % 24];
            counts[hour]++;
        }
        return res;
    }
}
