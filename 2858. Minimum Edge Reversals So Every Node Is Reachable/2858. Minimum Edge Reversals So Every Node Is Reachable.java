/*
 * Problem: 2858. Minimum Edge Reversals So Every Node Is Reachable
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-edge-reversals-so-every-node-is-reachable/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<List<int[]>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            links.get(edge[0]).add(new int[] { edge[1], 1 });
            links.get(edge[1]).add(new int[] { edge[0], 0 });
        }
        towards = new int[n];
        dfs(links, 0, -1, dfs(links, 0, -1));
        return towards;
    }

    int[] towards;

    public int dfs(List<List<int[]>> links, int i, int prv) {
        int res = 0;
        for (int[] next : links.get(i)) {
            if (next[0] == prv)
                continue;
            res += dfs(links, next[0], i) + 1 - next[1];
        }
        return res;
    }

    public void dfs(List<List<int[]>> links, int i, int prv, int toward) {
        towards[i] = toward;
        List<int[]> list = links.get(i);
        for (int[] next : links.get(i)) {
            if (next[0] == prv)
                continue;
            dfs(links, next[0], i, toward + 2 * next[1] - 1);
        }
    }
}
