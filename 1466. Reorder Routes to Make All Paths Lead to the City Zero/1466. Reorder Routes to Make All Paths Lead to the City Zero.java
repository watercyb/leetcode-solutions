/*
 * Problem: 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int minReorder(int n, int[][] connections) {
        int res = 0;
        boolean[] seens = new boolean[n];
        seens[0] = true;
        for (boolean isChanged = true; isChanged;) {
            isChanged = false;
            for (int i = 0; i < connections.length; i++) {
                if (seens[connections[i][1]] && !seens[connections[i][0]]) {
                    seens[connections[i][0]] = true;
                    isChanged = true;
                } else if (seens[connections[i][0]] && !seens[connections[i][1]]) {
                    seens[connections[i][1]] = true;
                    res++;
                    isChanged = true;
                }
            }
            for (int i = connections.length - 1; i >= 0; i--) {
                if (seens[connections[i][1]] && !seens[connections[i][0]]) {
                    seens[connections[i][0]] = true;
                    isChanged = true;
                } else if (seens[connections[i][0]] && !seens[connections[i][1]]) {
                    seens[connections[i][1]] = true;
                    res++;
                    isChanged = true;
                }
            }
        }
        return res;
    }
}
