/*
 * Problem: 2139. Minimum Moves to Reach Target Score
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-reach-target-score/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minMoves(int target, int maxDoubles) {
        maxDoubles = Math.min(maxDoubles, 31 - Integer.numberOfLeadingZeros(target));
        return (target >> maxDoubles) - 1 + maxDoubles + Integer.bitCount(target & ((1 << maxDoubles) - 1));
    }
}
