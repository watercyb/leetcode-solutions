/*
 * Problem: 1690. Stone Game VII
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/stone-game-vii/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int stoneGameVII(int[] stones) {
        int[] DP = new int[stones.length];
        for (int i = 0; i < DP.length; i++) {
            int sum = stones[i];
            for (int j = i - 1; j >= 0; j--) {
                sum += stones[j];
                DP[j] = Math.max(sum - DP[j + 1] - stones[j], sum - DP[j] - stones[i]);
            }
        }
        return DP[0];
    }
}
