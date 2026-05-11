/*
 * Problem: 3820. Pythagorean Distance Nodes in a Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/pythagorean-distance-nodes-in-a-tree/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][] links = new int[n][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]];
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = edge[1];
            links[edge[1]][--counts[edge[1]]] = edge[0];
        }
        int[] xStps = new int[n];
        dfs(links, xStps, x, -1, 0);
        int[] yStps = new int[n];
        dfs(links, yStps, y, -1, 0);
        int[] zStps = new int[n];
        dfs(links, zStps, z, -1, 0);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (check(xStps[i], yStps[i], zStps[i]))
                res++;
        }
        return res;
    }

    public boolean check(int a, int b, int c) {
        if (a >= b && a >= c) {
            return chk(a, b, c);
        } else if (b >= a && b >= c) {
            return chk(b, a, c);
        } else if (c >= a && c >= b) {
            return chk(c, a, b);
        }
        return false;
    }

    public boolean chk(int a, int b, int c) {
        return a * a == b * b + c * c;
    }

    public void dfs(int[][] links, int[] stps, int i, int prv, int stp) {
        stps[i] = stp++;
        for (int next : links[i]) {
            if (next != prv)
                dfs(links, stps, next, i, stp);
        }
    }
}
