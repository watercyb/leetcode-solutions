/*
 * Problem: 3807. Minimum Cost to Repair Edges to Traverse a Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-repair-edges-to-traverse-a-graph/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int minCost(int n, int[][] edges, int k) {
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][][] links = new int[n][][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]][];
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = new int[] { edge[1], edge[2] };
            links[edge[1]][--counts[edge[1]]] = new int[] { edge[0], edge[2] };
        }
        int max = 0;
        for (int i = 0; i < links.length; i++) {
            if (links[i].length > 0) {
                Arrays.sort(links[i], (a, b) -> a[1] - b[1]);
                max = Math.max(max, links[i][links[i].length - 1][1]);
            }
        }
        arr = new int[n];
        int l = 0;
        int r = max + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(links, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == max + 1)
            return -1;
        return l;
    }

    int[] arr;

    public boolean chk(int[][][] links, int k, int mid) {
        boolean[] seens = new boolean[links.length];
        seens[0] = true;
        arr[0] = 0;
        int l = 0;
        int r = 1;
        for (int i = 0; i <= k; i++) {
            int lim = r;
            while (l < lim) {
                int current = arr[l++];
                if (current == links.length - 1)
                    return true;
                for (int[] next : links[current]) {
                    if (seens[next[0]] || next[1] > mid)
                        continue;
                    seens[next[0]] = true;
                    arr[r++] = next[0];
                }
            }
        }
        return false;
    }
}
