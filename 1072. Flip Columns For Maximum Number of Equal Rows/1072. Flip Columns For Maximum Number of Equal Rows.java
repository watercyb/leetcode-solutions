/*
 * Problem: 1072. Flip Columns For Maximum Number of Equal Rows
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] ^= 1;
                }
            }
            int h = Arrays.hashCode(matrix[i]);
            int count = HM.getOrDefault(h, 0) + 1;
            res = Math.max(count, res);
            HM.put(h, count);
        }
        return res;
    }
}
