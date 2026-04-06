/*
 * Problem: 685. Redundant Connection II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/redundant-connection-ii/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] counts = new int[edges.length + 1];
        int[] links = new int[edges.length + 1];
        for (int i = 1; i < links.length; i++) {
            links[i] = i;
        }
        int count = 0;
        int[] res = null;
        int[] res1 = null;
        for (int[] edge : edges) {
            int a = unionFind(links, edge[0]);
            int b = unionFind(links, edge[1]);
            if (a != b) {
                links[a] = b;
            } else {
                res1 = edge;
            }
            if (counts[edge[1]]++ == 1) {
                for (int i = 0; i < edges.length; i++) {
                    if (edges[i][1] == edge[1]) {
                        count++;
                        if (chk(edges, i)) {
                            if (count == 1)
                                return edges[i];
                            res = edges[i];
                        }
                    }
                }
            }
        }
        if (res != null) {
            return res;
        }
        return res1;
    }

    public boolean chk(int[][] edges, int j) {
        int[] links = new int[edges.length + 1];
        for (int i = 1; i < links.length; i++) {
            links[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == j)
                continue;
            int a = unionFind(links, edges[i][0]);
            int b = unionFind(links, edges[i][1]);
            if (a != b) {
                links[a] = b;
            } else {
                return false;
            }
        }
        return true;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
