/*
 * Problem: 1275. Find Winner on a Tic Tac Toe Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public String tictactoe(int[][] moves) {
        String[] winner = { "B", "", "A" };
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int diagAnti = 0;
        int p = 1;
        for (int[] move : moves) {
            rows[move[0]] += p;
            if (Math.abs(rows[move[0]]) == 3)
                return winner[p + 1];
            cols[move[1]] += p;
            if (Math.abs(cols[move[1]]) == 3)
                return winner[p + 1];
            if (move[0] == move[1]) {
                diag += p;
                if (Math.abs(diag) == 3)
                    return winner[p + 1];
            }
            if (2 - move[0] == move[1]) {
                diagAnti += p;
                if (Math.abs(diagAnti) == 3)
                    return winner[p + 1];
            }
            p = -p;
        }
        if (moves.length == 9)
            return "Draw";
        return "Pending";
    }
}
