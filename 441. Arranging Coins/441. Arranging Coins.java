/*
 * Problem: 441. Arranging Coins
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/arranging-coins/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(8l * n + 1) - 1) / 2);
    }
}
