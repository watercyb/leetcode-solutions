/*
 * Problem: 3274. Check if Two Chessboard Squares Have the Same Color
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return (coordinate1.charAt(0) + coordinate1.charAt(1)) % 2 == (coordinate2.charAt(0) + coordinate2.charAt(1))
                % 2;
    }
}
