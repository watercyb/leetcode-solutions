/*
 * Problem: 2033. Minimum Operations to Make a Uni-Value Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minOperations(int[][] grid, int x) {
        int mod = grid[0][0] % x;
        int[] counts = new int[10001];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] % x != mod)
                    return -1;
                counts[grid[i][j]]++;
            }
        }
        int res = 0;
        int l = 0;
        int r = 10000;
        while (l < r) {
            if (counts[l] < counts[r]) {
                res += counts[l] * (r - l);
                counts[r] -= counts[l];
                l++;
            } else if (counts[l] > counts[r]) {
                res += counts[r] * (r - l);
                counts[l] -= counts[r];
                r--;
            } else {
                res += counts[l] * (r - l);
                l++;
                r--;
            }
        }
        return res / x;
    }
}
