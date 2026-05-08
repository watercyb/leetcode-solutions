/*
 * Problem: 3549. Multiply Two Polynomials
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/multiply-two-polynomials/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long[] multiply(int[] poly1, int[] poly2) {
        long[] res = new long[poly1.length + poly2.length - 1];
        for (int i = 0; i < poly1.length; i++) {
            if (poly1[i] == 0)
                continue;
            for (int j = 0; j < poly2.length; j++) {
                res[i + j] += poly1[i] * poly2[j];
            }
        }
        return res;
    }
}
