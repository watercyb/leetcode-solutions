/*
 * Problem: 3108. Minimum Cost Walk in Weighted Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] links = new int[n];
        int[] masks = new int[n];
        int mask = -1;
        for (int i = 0; i < n; i++) {
            links[i] = i;
            masks[i] = mask;
        }
        for (int[] edge : edges) {
            int a = find(links, edge[0]);
            int b = find(links, edge[1]);
            if (a != b) {
                links[a] = b;
                masks[b] &= masks[a] & edge[2];
            } else {
                masks[a] &= edge[2];
            }
        }
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int a = find(links, query[i][0]);
            int b = find(links, query[i][1]);
            if (a != b) {
                res[i] = -1;
            } else {
                res[i] = masks[a];
            }
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
