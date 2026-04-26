/*
 * Problem: 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        for (int[] edge : edges) {
            int a = unionFind(links, edge[0]);
            int b = unionFind(links, edge[1]);
            if (a != b) {
                links[a] = b;
                counts[b] += counts[a];
                counts[a] = 0;
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) counts[i] * (n - counts[i]);
        }
        return res / 2;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
