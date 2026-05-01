/*
 * Problem: 2849. Determine if a Cell Is Reachable at a Given Time
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dist = Math.max(Math.abs(fx - sx), Math.abs(fy - sy));
        if (dist > t || (dist == 0 && t == 1))
            return false;
        return true;
    }
}
