/*
 * Problem: 684. Redundant Connection
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/redundant-connection/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] links = new int[edges.length + 1];
        for (int i = 1; i < links.length; i++) {
            links[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int a = find(links, edges[i][0]);
            int b = find(links, edges[i][1]);
            if (a == b)
                return edges[i];
            links[a] = b;
        }
        return new int[0];
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
