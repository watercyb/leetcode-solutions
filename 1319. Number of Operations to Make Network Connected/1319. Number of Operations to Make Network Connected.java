/*
 * Problem: 1319. Number of Operations to Make Network Connected
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        for (int[] connection : connections) {
            int a = unionFind(links, connection[0]);
            int b = unionFind(links, connection[1]);
            if (a != b) {
                links[a] = b;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (links[i] == i)
                res++;
        }
        return res - 1;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
