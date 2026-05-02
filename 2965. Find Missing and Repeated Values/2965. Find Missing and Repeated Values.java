/*
 * Problem: 2965. Find Missing and Repeated Values
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-missing-and-repeated-values/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] counts = new int[grid.length * grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                counts[grid[i][j]]++;
            }
        }
        int[] res = new int[2];
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                res[1] = i;
            } else if (counts[i] == 2) {
                res[0] = i;
            }
        }
        return res;
    }
}
