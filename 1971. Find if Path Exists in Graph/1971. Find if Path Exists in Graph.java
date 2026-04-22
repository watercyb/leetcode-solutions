/*
 * Problem: 1971. Find if Path Exists in Graph
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-if-path-exists-in-graph/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] seen = new boolean[n];
        seen[source] = true;
        for (boolean changed = true; changed;) {
            changed = false;
            for (int i = 0; i < edges.length; i++) {
                if (seen[edges[i][0]] != seen[edges[i][1]]) {
                    seen[edges[i][0]] = true;
                    seen[edges[i][1]] = true;
                    changed = true;
                }
            }
            for (int i = edges.length - 1; i >= 0; i--) {
                if (seen[edges[i][0]] != seen[edges[i][1]]) {
                    seen[edges[i][0]] = true;
                    seen[edges[i][1]] = true;
                    changed = true;
                }
            }
            if (seen[destination])
                return true;
        }
        return false;
    }
}
