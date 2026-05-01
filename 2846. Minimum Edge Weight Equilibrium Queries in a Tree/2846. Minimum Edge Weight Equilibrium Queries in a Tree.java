/*
 * Problem: 2846. Minimum Edge Weight Equilibrium Queries in a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-edge-weight-equilibrium-queries-in-a-tree/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    int[] tmp;
    int[][] sum;
    List<int[]>[] Li;
    int[] dps;

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        if (n == 1)
            return new int[] { 0 };

        tmp = new int[n];
        sum = new int[n][27];
        Li = new ArrayList[n];
        for (int[] edge : edges) {
            if (Li[edge[0]] == null)
                Li[edge[0]] = new ArrayList<>();
            if (Li[edge[1]] == null)
                Li[edge[1]] = new ArrayList<>();
            Li[edge[0]].add(new int[] { edge[1], edge[2] });
            Li[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        tmp[edges[0][0]] = -1;
        dps = new int[n];
        getList(edges, edges[0][0], 0);

        int cl = n;
        int rl = (int) (Math.log(n) / Math.log(2) + 2);
        int[][] BL = new int[rl][cl];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (i == 0) {
                    BL[i][j] = tmp[j];
                } else if (BL[i - 1][j] != -1) {
                    BL[i][j] = BL[i - 1][BL[i - 1][j]];
                } else {
                    BL[i][j] = -1;
                }
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int lca = LCA(BL, queries[i][0], queries[i][1]);
            int max = 0;
            for (int j = 1; j <= 26; j++) {
                int count = sum[queries[i][0]][j] + sum[queries[i][1]][j] - sum[lca][j] * 2;
                res[i] += count;
                if (count > max)
                    max = count;
            }
            res[i] -= max;
        }
        return res;
    }

    public void getList(int[][] edges, int child, int dp) {
        dps[child] = dp;
        for (int[] in : Li[child]) {
            if (in[0] == tmp[child])
                continue;
            tmp[in[0]] = child;
            int[] sumTmp = sum[child].clone();
            sumTmp[in[1]]++;
            sum[in[0]] = sumTmp;
            getList(edges, in[0], dp + 1);
        }
    }

    public int LCA(int[][] BL, int n1, int n2) {
        if (dps[n1] > dps[n2]) {
            n1 = getNode(BL, n1, dps[n1] - dps[n2]);
        } else {
            n2 = getNode(BL, n2, dps[n2] - dps[n1]);
        }
        if (n1 == n2)
            return n1;
        for (int i = BL.length - 1; i >= 0; i--) {
            int n1Tmp = BL[i][n1];
            int n2Tmp = BL[i][n2];
            if (n1Tmp == n2Tmp)
                continue;
            n1 = n1Tmp;
            n2 = n2Tmp;
        }
        return BL[0][n1];
    }

    public int getNode(int[][] BL, int node, int diff) {
        int r = 0;
        while ((diff >>> r) > 0) {
            if ((diff >>> r & 1) == 1) {
                node = BL[r][node];
                if (node == -1)
                    return -1;
            }
            r++;
        }
        return node;
    }

}
