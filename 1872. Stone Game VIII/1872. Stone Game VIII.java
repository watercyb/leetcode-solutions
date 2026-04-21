/*
 * Problem: 1872. Stone Game VIII
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/stone-game-viii/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int stoneGameVIII(int[] stones) {
        for (int i = 1; i < stones.length; i++) {
            stones[i] += stones[i - 1];
        }
        int res = stones[stones.length - 1];
        for (int i = stones.length - 2; i > 0; i--) {
            res = Math.max(stones[i] - res, res);
        }
        return res;
    }
}
