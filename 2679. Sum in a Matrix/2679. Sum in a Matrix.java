/*
 * Problem: 2679. Sum in a Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-in-a-matrix/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int matrixSum(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }
        int res = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int max = 0;
            for (int j = 0; j < nums.length; j++) {
                max = Math.max(nums[j][i], max);
            }
            res += max;
        }
        return res;
    }
}
