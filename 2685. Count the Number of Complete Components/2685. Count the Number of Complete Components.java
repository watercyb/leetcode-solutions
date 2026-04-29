/*
 * Problem: 2685. Count the Number of Complete Components
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-complete-components/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] links = new int[n];
        int[] counts = new int[n];
        int[] countEdges = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
            counts[i] = 1;
        }
        for (int[] edge : edges) {
            int a = find(links, edge[0]);
            int b = find(links, edge[1]);
            if (a != b) {
                links[a] = b;
                counts[b] += counts[a];
                countEdges[b] += countEdges[a] + 1;
            } else {
                countEdges[a]++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (links[i] == i && counts[i] * (counts[i] - 1) / 2 == countEdges[i])
                res++;
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
