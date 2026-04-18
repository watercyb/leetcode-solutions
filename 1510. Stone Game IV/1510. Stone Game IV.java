/*
 * Problem: 1510. Stone Game IV
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/stone-game-iv/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] DP = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (DP[i])
                continue;
            for (int j = 1; j * j <= n - i; j++) {
                DP[i + j * j] = true;
            }
        }
        return DP[n];
    }
}
