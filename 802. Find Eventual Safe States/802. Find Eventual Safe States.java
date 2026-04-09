/*
 * Problem: 802. Find Eventual Safe States
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-eventual-safe-states/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Boolean[] seens = new Boolean[graph.length];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, seens, i))
                res.add(i);
        }
        return res;
    }

    public boolean dfs(int[][] graph, Boolean[] seens, int i) {
        if (seens[i] != null)
            return seens[i];
        if (graph[i].length == 0)
            return seens[i] = true;
        seens[i] = false;
        boolean res = true;
        for (int next : graph[i]) {
            if (!dfs(graph, seens, next))
                res = false;
        }
        return seens[i] = res;
    }
}
