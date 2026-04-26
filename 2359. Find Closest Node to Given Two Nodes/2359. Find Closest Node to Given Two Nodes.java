/*
 * Problem: 2359. Find Closest Node to Given Two Nodes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == -1)
                edges[i] = i;
        }
        int[] seens = new int[edges.length];
        return dfs(edges, seens, node1, node2, 0);
    }

    public int dfs(int[] edges, int[] seens, int node1, int node2, int stp) {
        if (seens[node1] == 1 && seens[node2] == 2)
            return -1;
        seens[node1] |= 1;
        seens[node2] |= 2;
        if (seens[node1] == 3 && seens[node2] == 3)
            return Math.min(node1, node2);
        if (seens[node1] == 3)
            return node1;
        if (seens[node2] == 3)
            return node2;
        return dfs(edges, seens, edges[node1], edges[node2], stp + 1);
    }
}
