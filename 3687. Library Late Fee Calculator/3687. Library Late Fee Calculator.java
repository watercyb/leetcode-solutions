/*
 * Problem: 3687. Library Late Fee Calculator
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/library-late-fee-calculator/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int lateFee(int[] daysLate) {
        int res = 0;
        for (int day : daysLate) {
            if (day == 1) {
                res++;
            } else if (day <= 5) {
                res += 2 * day;
            } else {
                res += 3 * day;
            }
        }
        return res;
    }
}
