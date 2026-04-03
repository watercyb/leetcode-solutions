/*
 * Problem: 348. Design Tic-Tac-Toe
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-tic-tac-toe/
 * Language: java
 * Date: 2026-04-03
 */

class TicTacToe {
    int[][] board;
    int[] rows;
    int[] cols;
    int dia1;
    int dia2;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        dia1 = 0;
        dia2 = 0;
    }

    public int move(int row, int col, int player) {
        int p = 0;
        int target = n;
        if (player == 1) {
            p = -1;
            target *= -1;
        } else {
            p = 1;
        }
        rows[row] += p;
        cols[col] += p;
        if (row == col)
            dia1 += p;
        if (n - 1 - row == col)
            dia2 += p;
        if (rows[row] == target || cols[col] == target
                || dia1 == target || dia2 == target)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
