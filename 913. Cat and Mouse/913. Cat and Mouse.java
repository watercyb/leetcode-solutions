/*
 * Problem: 913. Cat and Mouse
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/cat-and-mouse/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int catMouseGame(int[][] graph) {
        int[][][] results = new int[graph.length][graph.length][2];
        int[][][] counts = new int[graph.length][graph.length][2];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                counts[i][j][0] = graph[i].length;
                counts[i][j][1] = graph[j].length;
                for (int in : graph[j]) {
                    if (in == 0)
                        counts[i][j][1]--;
                    break;
                }
            }
        }
        Queue<int[]> Qu = new LinkedList<>();
        for (int i = 1; i < graph.length; i++) {
            results[0][i][0] = 1;
            Qu.offer(new int[] { 0, i, 0, 1 });
            results[i][i][0] = 2;
            Qu.offer(new int[] { i, i, 0, 2 });
            results[i][i][1] = 2;
            Qu.offer(new int[] { i, i, 1, 2 });
        }
        while (!Qu.isEmpty()) {
            int[] tmp = Qu.poll();
            if (tmp[2] == 0) {
                for (int next : graph[tmp[0]]) {
                    if (results[next][tmp[1]][0] > 0)
                        continue;
                    if (tmp[3] == 1 || --counts[next][tmp[1]][0] == 0) {
                        results[next][tmp[1]][0] = tmp[3];
                        if (next == 1 && tmp[1] == 2)
                            return tmp[3];
                        Qu.offer(new int[] { next, tmp[1], 1, tmp[3] });
                    }
                }
            } else {
                for (int next : graph[tmp[1]]) {
                    if (results[tmp[0]][next][1] > 0 || next == 0)
                        continue;
                    if (tmp[3] == 2 || --counts[tmp[0]][next][1] == 0) {
                        results[tmp[0]][next][1] = tmp[3];
                        Qu.offer(new int[] { tmp[0], next, 0, tmp[3] });
                    }
                }
            }
        }
        return results[1][2][0];
    }
}
