/*
 * Problem: 335. Self Crossing
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/self-crossing/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean isSelfCrossing(int[] distance) {
        if (distance.length <= 3)
            return false;
        int idx = 2;
        while (idx < distance.length && distance[idx] > distance[idx - 2]) {
            idx++;
        }
        idx++;
        if (idx >= distance.length)
            return false;
        if (idx >= 4 && distance[idx - 1] >= distance[idx - 3] - (idx >= 5 ? distance[idx - 5] : 0)
                && distance[idx] >= distance[idx - 2] - distance[idx - 4])
            return true;
        while (idx < distance.length && distance[idx] < distance[idx - 2]) {
            idx++;
        }
        return idx < distance.length;
    }
}
