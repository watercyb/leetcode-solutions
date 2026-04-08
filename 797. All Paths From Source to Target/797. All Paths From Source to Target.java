/*
 * Problem: 797. All Paths From Source to Target
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/all-paths-from-source-to-target/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, res, list, new boolean[graph.length], 0);
        return res;
    }

    public void dfs(int[][] graph, List<List<Integer>> res, List<Integer> list, boolean[] seens, int i) {
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(list));
        }
        for (int next : graph[i]) {
            if (!seens[next]) {
                seens[next] = true;
                list.add(next);
                dfs(graph, res, list, seens, next);
                list.removeLast();
                seens[next] = false;
            }
        }
    }
}
