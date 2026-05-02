/*
 * Problem: 2946. Matrix Similarity After Cyclic Shifts
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != mat[i][(j + k) % mat[0].length])
                    return false;
            }
        }
        return true;
    }
}
