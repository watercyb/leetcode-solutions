/*
 * Problem: 2643. Row With Maximum Ones
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/row-with-maximum-ones/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0;
        int idx = 0;
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int num : mat[i]) {
                sum += num;
            }
            if (sum > max) {
                max = sum;
                idx = i;
            }
        }
        return new int[] { idx, max };
    }
}
