/*
 * Problem: 2876. Count Visited Nodes in a Directed Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-visited-nodes-in-a-directed-graph/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int[] links = new int[edges.size()];
        for (int i = 0; i < links.length; i++) {
            links[i] = edges.get(i);
        }
        int[] counts = new int[links.length];
        int[] stps = new int[links.length];
        for (int i = 0; i < links.length; i++) {
            if (counts[i] == 0)
                dfs(links, counts, stps, i, 1);
        }
        return counts;
    }

    public int dfs(int[] links, int[] counts, int[] stps, int i, int n) {
        stps[i] = n;
        int next = links[i];
        if (counts[next] != 0) {
            counts[i] = counts[next] + 1;
            return n;
        } else if (stps[next] > 0) {
            counts[i] = n - stps[next] + 1;
            return stps[next];
        } else {
            int res = dfs(links, counts, stps, next, n + 1);
            if (n >= res) {
                counts[i] = counts[next];
            } else {
                counts[i] = counts[next] + 1;
            }
            return res;
        }
    }
}
