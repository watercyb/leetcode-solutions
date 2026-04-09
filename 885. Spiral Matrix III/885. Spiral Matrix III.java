/*
 * Problem: 885. Spiral Matrix III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/spiral-matrix-iii/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    int idx = 0;
    int stps = 1;
    int rows = 0;
    int cols = 0;
    int rStart = 0;
    int cStart = 0;
    int[][] res;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        this.rows = rows;
        this.cols = cols;
        this.rStart = rStart;
        this.cStart = cStart;
        res = new int[rows * cols][2];
        while (idx < rows * cols) {
            move(0, 1);
            move(1, 0);
            stps++;
            move(0, -1);
            move(-1, 0);
            stps++;
        }
        return res;
    }

    public void move(int r, int c) {
        for (int i = 0; i < stps; i++) {
            if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                res[idx][0] = rStart;
                res[idx][1] = cStart;
                idx++;
            }
            rStart += r;
            cStart += c;
        }
    }
}
