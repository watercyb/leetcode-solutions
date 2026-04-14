/*
 * Problem: 1129. Shortest Path with Alternating Colors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-path-with-alternating-colors/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] r = new ArrayList[n];
        List<Integer>[] b = new ArrayList[n];
        Queue<int[]> Qu = new LinkedList<>();
        int[][] stps = new int[n][2];
        for (int i = 0; i < n; i++) {
            r[i] = new ArrayList<>();
            b[i] = new ArrayList<>();
            stps[i][0] = Integer.MAX_VALUE;
            stps[i][1] = Integer.MAX_VALUE;
        }
        for (int[] edge : redEdges)
            r[edge[0]].add(edge[1]);
        for (int[] edge : blueEdges)
            b[edge[0]].add(edge[1]);
        stps[0][0] = 0;
        stps[0][1] = 0;
        for (int ver : r[0]) {
            if (stps[ver][0] == Integer.MAX_VALUE) {
                stps[ver][0] = 1;
                Qu.add(new int[] { ver, 0 });
            }
        }
        for (int ver : b[0]) {
            if (stps[ver][1] == Integer.MAX_VALUE) {
                stps[ver][1] = 1;
                Qu.add(new int[] { ver, 1 });
            }
        }
        while (!Qu.isEmpty()) {
            int[] stp = Qu.poll();
            if (stp[1] == 0) {
                for (int ver : b[stp[0]]) {
                    if (stps[ver][1] == Integer.MAX_VALUE) {
                        stps[ver][1] = stps[stp[0]][0] + 1;
                        Qu.add(new int[] { ver, 1 });
                    }
                }
            } else {
                for (int ver : r[stp[0]]) {
                    if (stps[ver][0] == Integer.MAX_VALUE) {
                        stps[ver][0] = stps[stp[0]][1] + 1;
                        Qu.add(new int[] { ver, 0 });
                    }
                }
            }
        }
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            int tmp = Math.min(stps[i][0], stps[i][1]);
            if (tmp == Integer.MAX_VALUE) {
                res[i] = -1;
            } else {
                res[i] = tmp;
            }
        }
        return res;
    }
}
