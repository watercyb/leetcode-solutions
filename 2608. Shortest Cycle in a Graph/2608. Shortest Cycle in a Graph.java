/*
 * Problem: 2608. Shortest Cycle in a Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-cycle-in-a-graph/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] lists = new ArrayList[n];
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
            links[i] = i;
        }
        arr = new int[n];
        int res = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
            int a = find(links, edge[0]);
            int b = find(links, edge[1]);
            if (a != b) {
                links[a] = b;
            } else {
                res = Math.min(getStp(lists, edge[0], edge[1]), res);
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }

    int[] arr;

    public int getStp(List<Integer>[] links, int a, int b) {
        boolean[] seens = new boolean[links.length];
        seens[a] = true;
        int l = 0;
        int r = 1;
        arr[0] = a;
        int res = 2;
        while (l < r) {
            int len = r;
            while (l < len) {
                int current = arr[l++];
                for (int next : links[current]) {
                    if (current == a && next == b)
                        continue;
                    if (next == b)
                        return res;
                    if (!seens[next]) {
                        seens[next] = true;
                        arr[r++] = next;
                    }
                }
            }
            res++;
        }
        return res;
    }
}
