/*
 * Problem: 1252. Cells with Odd Values in a Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] indice : indices) {
            rows[indice[0]]++;
            cols[indice[1]]++;
        }
        int res = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if ((cols[i] & 1) == 0)
                even++;
        }
        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) == 0) {
                res += n - even;
            } else {
                res += even;
            }
        }
        return res;
    }
}
