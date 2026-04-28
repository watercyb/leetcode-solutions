/*
 * Problem: 2503. Maximum Number of Points From Grid Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int max = 0;
        for (int query : queries) {
            max = Math.max(query, max);
        }
        int[] arr = new int[max + 1];
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        PQ.add(new int[] { 0, 0, grid[0][0] });
        grid[0][0] = -1;
        int sum = 0;
        int idx = grid[0][0] + 1;
        while (!PQ.isEmpty() && idx <= max) {
            int[] current = PQ.poll();
            while (idx <= current[2] && idx <= max) {
                arr[idx++] = sum;
            }
            sum++;
            for (int[] dirt : directions) {
                int x = current[0] + dirt[0];
                int y = current[1] + dirt[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] >= 0) {
                    PQ.offer(new int[] { x, y, grid[x][y] });
                    grid[x][y] = -1;
                }
            }
        }
        while (idx <= max) {
            arr[idx++] = sum;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = arr[queries[i]];
        }
        return res;
    }
}
