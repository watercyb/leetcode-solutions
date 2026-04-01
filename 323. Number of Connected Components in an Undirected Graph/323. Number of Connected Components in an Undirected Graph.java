/*
 * Problem: 323. Number of Connected Components in an Undirected Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        for (int[] edge : edges) {
            int a = unionFind(links, edge[0]);
            int b = unionFind(links, edge[1]);
            if (a != b)
                links[a] = b;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (links[i] == i)
                res++;
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
