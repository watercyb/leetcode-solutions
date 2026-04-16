/*
 * Problem: 1380. Lucky Numbers in a Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int min = 0;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][min] > matrix[i][j])
                    min = j;
            }
            int k = 0;
            while (k < matrix.length && matrix[i][min] >= matrix[k][min]) {
                k++;
            }
            if (k == matrix.length)
                return Arrays.asList(matrix[i][min]);
        }
        return new ArrayList<>();
    }
}
