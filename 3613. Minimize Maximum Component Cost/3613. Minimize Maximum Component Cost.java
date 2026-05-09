/*
 * Problem: 3613. Minimize Maximum Component Cost
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-maximum-component-cost/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minCost(int n, int[][] edges, int k) {
        if (n <= k)
            return 0;
        int r = 0;
        for (int[] edge : edges) {
            r = Math.max(edge[2], r);
        }
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(n, edges, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }

    public boolean chk(int n, int[][] edges, int k, int mid) {
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[2] > mid)
                continue;
            int a = find(links, edge[0]);
            int b = find(links, edge[1]);
            if (a != b) {
                n--;
                links[a] = b;
            }
        }
        return n <= k;
    }
}
