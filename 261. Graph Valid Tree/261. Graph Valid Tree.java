/*
 * Problem: 261. Graph Valid Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/graph-valid-tree/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        int[] links = new int[n];
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        Arrays.fill(counts, 1);
        for (int[] edge : edges) {
            int a = unionFind(links, edge[0]);
            int b = unionFind(links, edge[1]);
            if (a == b)
                return false;
            links[a] = b;
            counts[b] += counts[a];
        }
        return counts[unionFind(links, 0)] == n;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
