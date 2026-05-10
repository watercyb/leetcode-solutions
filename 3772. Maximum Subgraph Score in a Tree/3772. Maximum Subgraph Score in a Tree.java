/*
 * Problem: 3772. Maximum Subgraph Score in a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-subgraph-score-in-a-tree/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[lists.length][];
        sums = new int[n][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            sums[i] = new int[links[i].length];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        res = new int[n];
        dfs(links, good, 0, -1);
        dfs(links, good, 0, -1, 0);
        return res;
    }

    int[] res;
    int[][] sums;

    public int dfs(int[][] links, int[] good, int i, int prv) {
        int sum = good[i] * 2 - 1;
        for (int j = 0; j < links[i].length; j++) {
            int next = links[i][j];
            if (next == prv)
                continue;
            int re = Math.max(dfs(links, good, next, i), 0);
            sums[i][j] = re;
            sum += re;
        }
        res[i] = sum;
        return sum;
    }

    public void dfs(int[][] links, int[] good, int i, int prv, int sum) {
        sum = Math.max(sum, 0);
        res[i] += sum;
        for (int j = 0; j < links[i].length; j++) {
            int next = links[i][j];
            if (next == prv)
                continue;
            dfs(links, good, next, i, res[i] - sums[i][j]);
        }
    }
}
