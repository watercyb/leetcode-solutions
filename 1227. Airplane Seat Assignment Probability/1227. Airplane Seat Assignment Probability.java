/*
 * Problem: 1227. Airplane Seat Assignment Probability
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/airplane-seat-assignment-probability/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1)
            return 1.0;
        return 0.5;
    }
}
