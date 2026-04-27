/*
 * Problem: 2467. Most Profitable Path in a Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/most-profitable-path-in-a-tree/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<Integer>[] lists = new ArrayList[edges.length + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        int[] stps = new int[links.length];
        Arrays.fill(stps, Integer.MAX_VALUE);
        dfs(links, 0, -1, stps, bob);
        dfs(links, 0, -1, amount, 0, stps, 0);
        return res;
    }

    int res = Integer.MIN_VALUE;

    public int dfs(int[][] links, int i, int prv, int[] stps, int bob) {
        if (i == bob)
            return stps[i] = 0;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            int stp = dfs(links, next, i, stps, bob);
            if (stp >= 0)
                return stps[i] = stp + 1;
        }
        return -1;
    }

    public void dfs(int[][] links, int i, int prv, int[] amount, int sum, int[] stps, int stp) {
        boolean isLast = true;
        if (stps[i] > stp) {
            sum += amount[i];
        } else if (stps[i] == stp) {
            sum += amount[i] / 2;
        }
        for (int next : links[i]) {
            if (next == prv)
                continue;
            dfs(links, next, i, amount, sum, stps, stp + 1);
            isLast = false;
        }
        if (isLast)
            res = Math.max(sum, res);
    }
}
