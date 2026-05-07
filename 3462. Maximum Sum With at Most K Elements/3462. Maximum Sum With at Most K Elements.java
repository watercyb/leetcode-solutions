/*
 * Problem: 3462. Maximum Sum With at Most K Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] idx = new int[grid.length];
        Arrays.fill(idx, grid[0].length - 1);
        for (int i = 0; i < grid.length; i++) {
            if (limits[i]-- > 0)
                PQ.offer(new int[] { i, grid[i][idx[i]--] });
        }
        long res = 0;
        while (k > 0) {
            int[] current = PQ.poll();
            res += current[1];
            k--;
            if (limits[current[0]]-- > 0)
                PQ.offer(new int[] { current[0], grid[current[0]][idx[current[0]]--] });
        }
        return res;
    }
}
