/*
 * Problem: 3067. Count Pairs of Connectable Servers in a Weighted Tree Network
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<List<int[]>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            lists.get(edge[0]).add(new int[] { edge[1], edge[2] });
            lists.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        int[][][] links = new int[lists.size()][][];
        for (int i = 0; i < links.length; i++) {
            List<int[]> list = lists.get(i);
            links[i] = new int[list.size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = list.get(j);
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (links.length < 2)
                continue;
            int sum = 0;
            for (int[] next : links[i]) {
                int count = dfs(links, next[0], i, next[1], signalSpeed);
                res[i] += sum * count;
                sum += count;
            }
        }
        return res;
    }

    public int dfs(int[][][] links, int i, int prv, int sum, int signalSpeed) {
        int res = 0;
        if (sum % signalSpeed == 0)
            res++;
        for (int[] next : links[i]) {
            if (next[0] == prv)
                continue;
            res += dfs(links, next[0], i, sum + next[1], signalSpeed);
        }
        return res;
    }
}
