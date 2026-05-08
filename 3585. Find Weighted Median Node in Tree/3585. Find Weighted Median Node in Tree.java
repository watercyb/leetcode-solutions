/*
 * Problem: 3585. Find Weighted Median Node in Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-weighted-median-node-in-tree/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] findMedian(int n, int[][] edges, int[][] queries) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        int m = (int) Math.ceil(Math.log(n) / Math.log(2));
        BLT = new int[m][n];
        weights = new long[m][n];
        depth = new int[n];
        dfs(lists, 0, 0, 0, 0);
        getBLT();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            long[] pair = LCA(a, b);
            int lca = (int) pair[0];
            long l = pair[1];
            long r = pair[2];
            if (l == r) {
                res[i] = lca;
            } else if (l > r) {
                res[i] = getIdx(a, l + r, true);
            } else {
                res[i] = getIdx(b, l + r, false);
            }
        }
        return res;
    }

    int[][] BLT;  
    long[][] weights;
    int[] depth;

    public int getIdx(int a, long target, boolean left) {
        long sum = 0;
        for (int i = BLT.length - 1; i >= 0; i--) {
            if ((sum + weights[i][a]) * 2 <= target) {
                sum += weights[i][a];
                a = BLT[i][a];
            }
        }
        if (left && sum * 2 < target) {
            return BLT[0][a];
        } else {
            return a;
        }
    }

    public long[] LCA(int u, int v) {
        boolean switched = false;
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
            switched = true;
        }
        long lenU = 0;
        long lenV = 0;
        for (int i = BLT.length - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                lenU += weights[i][u];
                u = BLT[i][u];
            }
        }
        if (u == v) {
            if (!switched) {
                return new long[] { (long) u, lenU, lenV };
            } else {
                return new long[] { (long) u, lenV, lenU };
            }
        }
        for (int i = BLT.length - 1; i >= 0; i--) {
            if (BLT[i][u] != BLT[i][v]) {
                lenU += weights[i][u];
                lenV += weights[i][v];
                u = BLT[i][u];
                v = BLT[i][v];
            }
        }
        lenU += weights[0][u];
        lenV += weights[0][v];
        if (!switched) {
            return new long[] { (long) BLT[0][u], lenU, lenV };
        } else {
            return new long[] { (long) BLT[0][u], lenV, lenU };
        }
    }

    public void getBLT() {
        for (int i = 1; i < BLT.length; i++) {
            for (int j = 0; j < BLT[0].length; j++) {
                int idx = BLT[i - 1][j];
                long w = weights[i - 1][j];
                BLT[i][j] = BLT[i - 1][idx];
                weights[i][j] = weights[i - 1][idx] + w;
            }
        }
    }

    public void dfs(List<int[]>[] lists, int i, int prv, int weight, int lv) {
        BLT[0][i] = prv;
        weights[0][i] = weight;
        depth[i] = lv;
        for (int[] next : lists[i]) {
            if (next[0] == prv)
                continue;
            dfs(lists, next[0], i, next[1], lv + 1);
        }
    }
}
