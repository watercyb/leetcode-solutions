/*
 * Problem: 2371. Minimize Maximum Value in a Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-maximum-value-in-a-grid/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int[][] minScore(int[][] grid) {
        Node[] nodes = new Node[grid.length * grid[0].length];
        int idx = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                nodes[idx++] = new Node(grid[i][j], i, j);
            }
        }
        Arrays.sort(nodes, (a, b) -> a.val - b.val);
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for (int i = 0; i < nodes.length; i++) {
            int max = Math.max(rows[nodes[i].x], cols[nodes[i].y]) + 1;
            rows[nodes[i].x] = max;
            cols[nodes[i].y] = max;
            grid[nodes[i].x][nodes[i].y] = max;
        }
        return grid;
    }
}

class Node {
    int val;
    int x;
    int y;

    public Node(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}
