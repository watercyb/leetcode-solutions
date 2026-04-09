/*
 * Problem: 847. Shortest Path Visiting All Nodes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int shortestPathLength(int[][] graph) {
        int vers = 1;
        for (int i = graph.length - 1; i > 0; i--) {
            vers = vers * 2 + 1;
        }
        boolean[][] seen = new boolean[graph.length][vers + 1];
        Queue<int[]> Qu = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            Qu.add(new int[] { i, 1 << i, 0 });
            seen[i][1 << i] = true;
        }
        while (!Qu.isEmpty()) {
            int[] stp = Qu.poll();
            for (int nextStp : graph[stp[0]]) {
                if (!seen[nextStp][stp[1]]) {
                    seen[nextStp][stp[1]] = true;
                    if ((stp[1] >>> nextStp & 1) == 0) {
                        int versTmp = stp[1] + (1 << nextStp);
                        if (versTmp == vers)
                            return stp[2] + 1;
                        Qu.add(new int[] { nextStp, versTmp, stp[2] + 1 });
                        seen[nextStp][versTmp] = true;
                    } else {
                        Qu.add(new int[] { nextStp, stp[1], stp[2] + 1 });
                        seen[nextStp][stp[1]] = true;
                    }
                }
            }
        }
        return 0;
    }
}
