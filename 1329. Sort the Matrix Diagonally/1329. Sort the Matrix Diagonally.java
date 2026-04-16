/*
 * Problem: 1329. Sort the Matrix Diagonally
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-the-matrix-diagonally/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            sort(mat, i, 0);
        }
        for (int i = 1; i < mat[0].length; i++) {
            sort(mat, 0, i);
        }
        return mat;
    }

    public void sort(int[][] mat, int i, int j) {
        int x = i;
        int y = j;
        List<Integer> list = new ArrayList<>();
        while (x < mat.length && y < mat[0].length) {
            list.add(mat[x++][y++]);
        }
        Collections.sort(list);
        for (int num : list) {
            mat[i++][j++] = num;
        }
    }
}
