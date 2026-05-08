/*
 * Problem: 3553. Minimum Weighted Subgraph With the Required Paths II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-weighted-subgraph-with-the-required-paths-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] minimumWeight(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        int len = (int) (Math.log(2 * n - 1) / Math.log(2)) + 1;
        sparse = new int[len][2 * n - 1];
        euler = new int[2 * n - 1];
        eulerIdxtoIdx = new int[2 * n - 1];
        idxToEulerIdx = new int[n];
        dists = new int[n];
        dfs(lists, 0, -1, 0, 0);
        getSparse();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = queries[i][2];
            res[i] = dists[a] + dists[b] + dists[c] - dists[LCA(a, b)] - dists[LCA(b, c)]
                    - dists[LCA(c, a)];
        }
        return res;
    }

    int[][] sparse;
    int[] euler;
    int[] eulerIdxtoIdx;
    int idx = 0;
    int[] idxToEulerIdx;
    int[] dists;

    public void dfs(List<int[]>[] lists, int i, int prv, int sum, int lv) {
        sparse[0][idx] = idx;
        euler[idx] = lv;
        eulerIdxtoIdx[idx] = i;
        idxToEulerIdx[i] = idx++;
        dists[i] = sum;
        for (int[] next : lists[i]) {
            if (next[0] == prv)
                continue;
            dfs(lists, next[0], i, sum + next[1], lv + 1);
            sparse[0][idx] = idx;
            euler[idx] = lv;
            eulerIdxtoIdx[idx++] = i;
        }
    }

    public void getSparse() {
        for (int i = 1; i < sparse.length; i++) {
            int inc = 1 << (i - 1);
            for (int j = 0; j < sparse[0].length; j++) {
                if (j + inc >= sparse[0].length)
                    continue;
                if (euler[sparse[i - 1][j + inc]] > euler[sparse[i - 1][j]]) {
                    sparse[i][j] = sparse[i - 1][j];
                } else {
                    sparse[i][j] = sparse[i - 1][j + inc];
                }
            }
        }
    }

    public int LCA(int a, int b) {
        int l = idxToEulerIdx[a];
        int r = idxToEulerIdx[b];
        if (l > r) {
            int temp = l;
            l = r;
            r = temp;
        }
        int k = 31 - Integer.numberOfLeadingZeros(r - l + 1);
        int left = sparse[k][l];
        int right = sparse[k][r - (1 << k) + 1];
        if (euler[left] < euler[right]) {
            return eulerIdxtoIdx[left];
        } else {
            return eulerIdxtoIdx[right];
        }
    }
}
