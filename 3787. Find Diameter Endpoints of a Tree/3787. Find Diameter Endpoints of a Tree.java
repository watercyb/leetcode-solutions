/*
 * Problem: 3787. Find Diameter Endpoints of a Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-diameter-endpoints-of-a-tree/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public String findSpecialNodes(int n, int[][] edges) {
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
        lens = new int[n];
        dfs(links, 0, -1, 0);
        char[] chrs = new char[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (lens[i] == max) {
                chrs[i] = '1';
                idx = i;
            } else {
                chrs[i] = '0';
            }
        }
        max = 0;
        dfs(links, idx, -1, 0);
        for (int i = 0; i < n; i++) {
            if (lens[i] == max)
                chrs[i] = '1';
        }
        return new String(chrs);
    }

    int max = 0;
    int[] lens;

    public void dfs(int[][] links, int i, int prv, int len) {
        lens[i] = len;
        max = Math.max(max, len);
        for (int next : links[i]) {
            if (next == prv)
                continue;
            dfs(links, next, i, len + 1);
        }
    }
}
