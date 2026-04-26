/*
 * Problem: 2360. Longest Cycle in a Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-cycle-in-a-graph/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int longestCycle(int[] edges) {
        boolean[] seens = new boolean[edges.length];
        int res = -1;
        for (int i = 0; i < edges.length; i++) {
            if (seens[i])
                continue;
            int j = edges[i];
            int count = 1;
            while (j != i && j != -1&&!seens[j]) {
                System.out.println(j);
                seens[j] = true;
                j = edges[j];
                count++;
            }
            if (j >= 0)
                res = Math.max(count, res);
        }
        return res;
    }
}
