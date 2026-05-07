/*
 * Problem: 3417. Zigzag Grid Traversal With Skip
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/zigzag-grid-traversal-with-skip/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        boolean needs = true;
        for (int i = 0; i < grid.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (needs)
                        res.add(grid[i][j]);
                    needs = !needs;
                }
            } else {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if (needs)
                        res.add(grid[i][j]);
                    needs = !needs;
                }
            }
        }
        return res;
    }
}
