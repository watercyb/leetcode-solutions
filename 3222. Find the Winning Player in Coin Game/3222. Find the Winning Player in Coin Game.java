/*
 * Problem: 3222. Find the Winning Player in Coin Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-winning-player-in-coin-game/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public String losingPlayer(int x, int y) {
        return new String[] { "Bob", "Alice" }[Math.min(x, y / 4) % 2];
    }
}
