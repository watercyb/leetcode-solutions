/*
 * Problem: 3887. Incremental Even-Weighted Cycle Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/incremental-even-weighted-cycle-queries/
 * Language: java
 * Date: 2026-03-30
 */

class Solution {
    public int numberOfEdgesAdded(int n, int[][] edges) {
        int[] links = new int[n];
        int[] lens = new int[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        int res = 0;
        for (int[] edge : edges) {
            int a = find(links, lens, edge[0]);
            int b = find(links, lens, edge[1]);
            int len = lens[edge[0]] ^ lens[edge[1]] ^ edge[2];
            if (a != b) {
                if (ranks[a] > ranks[b]) {
                    links[b] = a;
                    lens[b] = len;
                    ranks[a]++;
                } else {
                    links[a] = b;
                    lens[a] = len;
                    ranks[b]++;
                }
                res++;
            } else if (len == 0) {
                res++;
            }
        }
        return res;
    }

    public int find(int[] links, int[] lens, int i) {
        if (links[i] != i) {
            int next = links[i];
            links[i] = find(links, lens, next);
            lens[i] ^= lens[next];
        }
        return links[i];
    }
}
