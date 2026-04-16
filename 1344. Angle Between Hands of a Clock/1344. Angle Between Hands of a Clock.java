/*
 * Problem: 1344. Angle Between Hands of a Clock
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/angle-between-hands-of-a-clock/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public double angleClock(int hour, int minutes) {
        double res = Math.abs(hour % 12 * 30 - 5.5 * minutes);
        if (res > 180)
            res = 360 - res;
        return res;
    }
}
