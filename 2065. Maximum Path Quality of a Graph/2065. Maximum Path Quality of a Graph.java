/*
 * Problem: 2065. Maximum Path Quality of a Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-path-quality-of-a-graph/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<int[]>[] lists = new ArrayList[values.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            if (edge[2] >= maxTime)
                continue;
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        int[][][] links = new int[lists.length][][];
        for (int i = 0; i < lists.length; i++) {
            links[i] = new int[lists[i].size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        int v = values[0];
        values[0] = 0;
        dfs(links, values, 0, v, maxTime);
        return res;
    }

    int res = 0;

    public void dfs(int[][][] links, int[] values, int i, int sum, int time) {
        if (time < 0)
            return;
        if (i == 0)
            res = Math.max(sum, res);
        if (time < 10)
            return;
        for (int[] next : links[i]) {
            int v = values[next[0]];
            values[next[0]] = 0;
            dfs(links, values, next[0], sum + v, time - next[1]);
            values[next[0]] = v;
        }
    }
}
