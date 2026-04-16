/*
 * Problem: 1337. The K Weakest Rows in a Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        boolean[] seens = new boolean[101 * 101];
        for (int i = 0; i < mat.length; i++) {
            int h = 0;
            for (int num : mat[i]) {
                h += num;
            }
            h = h * 101 + i;
            seens[h] = true;
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; idx < res.length; i++) {
            if (seens[i])
                res[idx++] = i % 101;
        }
        return res;
    }
}
