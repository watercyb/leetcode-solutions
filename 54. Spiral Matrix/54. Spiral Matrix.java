/*
 * Problem: 54. Spiral Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/spiral-matrix/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirts = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        List<Integer> res=new ArrayList<>();
        int idx = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= matrix.length * matrix[0].length; i++) {
            res.add(matrix[x][y]);
            matrix[x][y]=Integer.MIN_VALUE;
            x += dirts[idx][0];
            y += dirts[idx][1];
            if (x < 0 || x == matrix.length || y < 0 || y == matrix[0].length || matrix[x][y] == Integer.MIN_VALUE) {
                x -= dirts[idx][0];
                y -= dirts[idx][1];
                idx = (idx + 1) % 4;
                x += dirts[idx][0];
                y += dirts[idx][1];
            }
        }
        return res;
    }
}
