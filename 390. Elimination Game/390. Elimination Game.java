/*
 * Problem: 390. Elimination Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/elimination-game/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int lastRemaining(int n) {
        if (n==1) return 1;
        return dfs(n, true);
    }

    public int dfs(int n, boolean left) {
        if (n == 1)
            return 1;
        int num = dfs(n / 2, !left);
        if (left || (n & 1) == 1) {
            return 2 * num;
        } else {
            return 2 * num - 1;
        }
    }
}
