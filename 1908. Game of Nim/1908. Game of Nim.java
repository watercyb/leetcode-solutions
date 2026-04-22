/*
 * Problem: 1908. Game of Nim
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/game-of-nim/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public boolean nimGame(int[] piles) {
        int nimSum = 0;
        for (int pile : piles) {
            nimSum ^= pile;
        }
        return nimSum != 0;
    }
}
