/*
 * Problem: 1582. Special Positions in a Binary Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int numSpecial(int[][] mat) {
        int[] r = new int[mat.length];
        int[] c = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==1) {
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int res=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==1&&r[i]==1&&c[j]==1) {
                    res++;
                }
            }
        }
    return res;
    }
}
