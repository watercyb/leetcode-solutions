/*
 * Problem: 3543. Maximum Weighted K-Edge Path
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-weighted-k-edge-path/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maxWeight(int n, int[][] edges, int k, int t) {
        if (k == 0)
            return 0;
        if (edges.length == 0)
            return -1;
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] counts = new int[n];
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            counts[edge[1]]++;
        }
        int[][][] links = new int[n][][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        HashSet<Integer> HS = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (dfs(links, HS, i, 0, k, t))
                return res;
        }
        return res;
    }

    int res = -1;

    public boolean dfs(int[][][] links, HashSet<Integer> HS, int i, int sum, int k, int t) {
        if (!HS.add(sum * 100000 + i * 301 + k) || sum >= t)
            return false;
        if (k == 0) {
            if (sum > res) {
                res = sum;
                if (res == t - 1)
                    return true;
            }
            return false;
        }
        for (int[] next : links[i]) {
            if (dfs(links, HS, next[0], sum + next[1], k - 1, t))
                return true;
        }
        return false;
    }
}
