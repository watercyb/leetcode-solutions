/*
 * Problem: 3189. Minimum Moves to Get a Peaceful Board
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-get-a-peaceful-board/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minMoves(int[][] rooks) {
        int[] rowsCount = new int[rooks.length];
        int[] colsCount = new int[rooks.length];
        for (int[] rook : rooks) {
            rowsCount[rook[0]]++;
            colsCount[rook[1]]++;
        }
        int res = 0;
        int count = 0;
        for (int i = 0; i < rooks.length; i++) {
            count += rowsCount[i] - 1;
            res += Math.abs(count);
        }
        for (int i = 0; i < rooks.length; i++) {
            count += colsCount[i] - 1;
            res += Math.abs(count);
        }
        return res;
    }
}
