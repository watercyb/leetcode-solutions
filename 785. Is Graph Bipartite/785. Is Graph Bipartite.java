/*
 * Problem: 785. Is Graph Bipartite?
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/is-graph-bipartite/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean isBipartite(int[][] graph) {
        Integer[] distances = new Integer[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (distances[i] == null && !dfs(graph, distances, i, 0))
                return false;
        }
        return true;
    }

    public boolean dfs(int[][] graph, Integer[] distances, int i, int n) {
        distances[i] = n;
        for (int next : graph[i]) {
            if (distances[next] == null) {
                if (!dfs(graph, distances, next, n + 1))
                    return false;
            } else {
                if ((distances[next] + n) % 2 == 0) 
                    return false;
            }
        }
        return true;
    }
}
