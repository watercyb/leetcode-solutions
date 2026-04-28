/*
 * Problem: 2543. Check if Point Is Reachable
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-if-point-is-reachable/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public boolean isReachable(int targetX, int targetY) {
        return Integer.bitCount(GCD(targetX, targetY)) == 1;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
