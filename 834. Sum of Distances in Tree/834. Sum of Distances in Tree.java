/*
 * Problem: 834. Sum of Distances in Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-distances-in-tree/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][] links = new int[n][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]];
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = edge[1];
            links[edge[1]][--counts[edge[1]]] = edge[0];
        }
        int[] res = new int[n];
        dfs(res, counts, links, 0, 0);
        dfs1(res, counts, links, 0, 0, n);
        return res;
    }

    public void dfs1(int[] res, int[] counts, int[][] links, int i, int prv, int n) {
        for (int next : links[i]) {
            if (next == prv)
                continue;
            res[next] = res[i] + n - 2 * counts[next];
            dfs1(res, counts, links, next, i, n);
        }
    }

    public void dfs(int[] res, int[] counts, int[][] links, int i, int prv) {
        int sumTmp = 0;
        int countTmp = 1;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            dfs(res, counts, links, next, i);
            countTmp += counts[next];
            sumTmp += res[next] + counts[next];
        }
        res[i] = sumTmp;
        counts[i] = countTmp;
    }
}
