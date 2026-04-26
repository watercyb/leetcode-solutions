/*
 * Problem: 2352. Equal Row and Column Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/equal-row-and-column-pairs/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int equalPairs(int[][] grid) {
        int mod = 1_000_000_007;
        HashMap<Long, Integer> HM = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            long h = 0;
            for (int j = 0; j < grid[0].length; j++) {
                h = (h * 100001 + grid[i][j]) % mod;
            }
            HM.put(h, HM.getOrDefault(h, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
            long h = 0;
            for (int j = 0; j < grid.length; j++) {
                h = (h * 100001 + grid[j][i]) % mod;
            }
            res += HM.getOrDefault(h, 0);
        }
        return res;
    }
}
