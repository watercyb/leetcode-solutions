/*
 * Problem: 1823. Find the Winner of the Circular Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int findTheWinner(int n, int k) {
        int a = 0;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (res >= a)
                res++;
            a = (a - k + 1 + k * i) % i;
        }
        return res - a + 1;
    }
}
