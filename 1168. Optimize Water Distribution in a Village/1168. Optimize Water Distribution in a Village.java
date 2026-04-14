/*
 * Problem: 1168. Optimize Water Distribution in a Village
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[][] connections = new int[wells.length + pipes.length][3];
        for (int i = 0; i < wells.length; i++) {
            connections[i] = new int[] { 0, i + 1, wells[i] };
        }
        for (int i = 0; i < pipes.length; i++) {
            connections[i + wells.length] = pipes[i];
        }
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int[] links = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            links[i] = i;
        }
        int res = 0;
        int i = 0;
        while (n > 0) {
            int a = unionFind(links, connections[i][0]);
            int b = unionFind(links, connections[i][1]);
            if (a != b) {
                res += connections[i][2];
                links[a] = b;
                n--;
            }
            i++;
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] == i)
            return i;
        links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
