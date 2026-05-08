/*
 * Problem: 3559. Number of Ways to Assign Edge Weights II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        if (pows == null) {
            pows = new int[100001];
            pows[0] = 1;
            for (int i = 1; i < pows.length; i++) {
                pows[i] = pows[i - 1] * 2 % mod;
            }
        }
        int n = edges.length + 1;
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0] - 1].add(edge[1] - 1);
            lists[edge[1] - 1].add(edge[0] - 1);
        }
        int len = (int) (Math.log(2 * n - 1) / Math.log(2)) + 1;
        sparse = new int[len][2 * n - 1];
        euler = new int[2 * n - 1];
        idxToEulerIdx = new int[n];
        dfs(lists, 0, -1, 0);
        getSparse();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == queries[i][1]) {
                res[i] = 0;
            } else {
                int a = idxToEulerIdx[queries[i][0] - 1];
                int b = idxToEulerIdx[queries[i][1] - 1];
                res[i] = pows[euler[a] + euler[b] - 2 * LCA(a, b) - 1];
            }
        }
        return res;
    }

    int mod = 1_000_000_007;
    int[][] sparse;
    int[] euler;
    int idx = 0;
    int[] idxToEulerIdx;
    static int[] pows;

    public void dfs(List<Integer>[] lists, int i, int prv, int lv) {
        sparse[0][idx] = idx;
        euler[idx] = lv;
        idxToEulerIdx[i] = idx++;
        for (int next : lists[i]) {
            if (next == prv)
                continue;
            dfs(lists, next, i, lv + 1);
            sparse[0][idx] = idx;
            euler[idx++] = lv;
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

    public int LCA(int l, int r) {
        if (l > r) {
            int temp = l;
            l = r;
            r = temp;
        }
        int k = 31 - Integer.numberOfLeadingZeros(r - l + 1);
        int left = sparse[k][l];
        int right = sparse[k][r - (1 << k) + 1];
        if (euler[left] < euler[right]) {
            return euler[left];
        } else {
            return euler[right];
        }
    }
}
