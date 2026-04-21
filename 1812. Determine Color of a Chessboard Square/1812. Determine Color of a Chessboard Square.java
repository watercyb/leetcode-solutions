/*
 * Problem: 1812. Determine Color of a Chessboard Square
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 != 0;
    }
}
