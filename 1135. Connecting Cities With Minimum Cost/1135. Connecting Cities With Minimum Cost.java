/*
 * Problem: 1135. Connecting Cities With Minimum Cost
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int minimumCost(int n, int[][] connections) {
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int res = 0;
        int count = 0;
        for (int i = 0; i < connections.length; i++) {
            int a = find(links, connections[i][0] - 1);
            int b = find(links, connections[i][1] - 1);
            int w = connections[i][2];
            if (a != b) {
                links[a] = b;
                count++;
                res += w;
            }
        }
        if (count != n - 1)
            return -1;
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
