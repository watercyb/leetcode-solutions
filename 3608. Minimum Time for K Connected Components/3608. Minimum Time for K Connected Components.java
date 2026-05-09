/*
 * Problem: 3608. Minimum Time for K Connected Components
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-for-k-connected-components/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minTime(int n, int[][] edges, int k) {
        int r = 0;
        for (int[] edge : edges) {
            r = Math.max(edge[2], r);
        }
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(edges, n, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[][] edges, int n, int k, int mid) {
        int[] links = getLinks(n);
        for (int[] edge : edges) {
            if (edge[2] > mid) {
                int a = find(links, edge[0]);
                int b = find(links, edge[1]);
                if (a != b) {
                    links[a] = b;
                    n--;
                }
            }
        }
        return n >= k;
    }

    public int[] getLinks(int n) {
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        return links;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
