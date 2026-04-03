/*
 * Problem: 498. Diagonal Traverse
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/diagonal-traverse/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        int x = 0;
        int y = 0;
        int idx = 0;
        while (idx < res.length) {
            while (x >= 0 && y < mat[0].length) {
                res[idx++] = mat[x][y];
                x--;
                y++;
            }
            if (y == mat[0].length) {
                x += 2;
                y--;
            } else {
                x++;
            }
            while (x < mat.length && y >= 0) {
                res[idx++] = mat[x][y];
                x++;
                y--;
            }
            if (x == mat.length) {
                x--;
                y += 2;
            } else {
                y++;
            }
        }
        return res;
    }
}
