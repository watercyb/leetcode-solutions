/*
 * Problem: 1536. Minimum Swaps to Arrange a Binary Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minSwaps(int[][] grid) {
        int[] lastOnes = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int j = grid[0].length - 1;
            while (j >= 0 && grid[i][j] == 0) {
                j--;
            }
            lastOnes[i] = j;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            if (lastOnes[i] <= i)
                continue;
            int j = i + 1;
            while (lastOnes[j] > i) {
                j++;
                if (j==grid.length) return -1;
            }
            res += j - i;
            for (int k = j - 1; k >= i; k--) {
                lastOnes[k + 1] = lastOnes[k];
            }
        }
        return res;
    }
}
