/*
 * Problem: 1886. Determine Whether Matrix Can Be Obtained By Rotation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if (chk1(mat, target))
            return true;
        if (chk2(mat, target))
            return true;
        if (chk3(mat, target))
            return true;
        if (chk4(mat, target))
            return true;
        return false;
    }

    public boolean chk1(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean chk2(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[j][mat.length - 1 - i])
                    return false;
            }
        }
        return true;
    }

    public boolean chk3(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[mat.length - 1 - i][mat[0].length - 1 - j])
                    return false;
            }
        }
        return true;
    }

    public boolean chk4(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[mat.length - 1 - j][i])
                    return false;
            }
        }
        return true;
    }
}
