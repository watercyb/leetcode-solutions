/*
 * Problem: 365. Water and Jug Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/water-and-jug-problem/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target)
            return false;
        return target % GCD(x, y) == 0;
    }

    public int GCD(int x, int y) {
        if (y == 0)
            return x;
        return GCD(y, x % y);
    }
}
