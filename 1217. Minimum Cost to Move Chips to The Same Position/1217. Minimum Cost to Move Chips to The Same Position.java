/*
 * Problem: 1217. Minimum Cost to Move Chips to The Same Position
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int minCostToMoveChips(int[] position) {
        int[] counts = new int[2];
        for (int pos : position) {
            counts[pos % 2]++;
        }
        return Math.min(counts[0], counts[1]);
    }
}
