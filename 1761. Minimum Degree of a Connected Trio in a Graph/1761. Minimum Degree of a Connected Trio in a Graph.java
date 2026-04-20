/*
 * Problem: 1761. Minimum Degree of a Connected Trio in a Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] links = new boolean[n][n];
        int[] counts = new int[n];
        for (int[] edge : edges) {
            links[edge[0] - 1][edge[1] - 1] = true;
            links[edge[1] - 1][edge[0] - 1] = true;
            counts[edge[0] - 1]++;
            counts[edge[1] - 1]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (counts[i] < 2)
                continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (counts[j] < 2 || !links[i][j])
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if (links[j][k] && links[i][k])
                        res = Math.min(counts[i] + counts[j] + counts[k] - 6, res);
                }
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
}
