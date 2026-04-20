/*
 * Problem: 1738. Find Kth Largest XOR Coordinate Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(matrix[i][j], max);
            }
        }
        max = (int) Math.pow(2, Math.ceil(Math.log(max) / Math.log(2)));
        int[] counts = new int[max];
        int[] XORs = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int XOR = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                XOR ^= matrix[i][j];
                XORs[j] ^= XOR;
                counts[XORs[j]]++;
            }
        }
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] >= k)
                return i;
            k -= counts[i];
        }
        return -1;
    }
}
