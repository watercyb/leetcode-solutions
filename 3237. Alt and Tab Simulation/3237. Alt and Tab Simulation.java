/*
 * Problem: 3237. Alt and Tab Simulation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/alt-and-tab-simulation/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] simulationResult(int[] windows, int[] queries) {
        boolean[] seens = new boolean[windows.length + 1];
        int[] res = new int[windows.length];
        int idx = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            if (seens[queries[i]])
                continue;
            seens[queries[i]] = true;
            res[idx++] = queries[i];
        }
        for (int i = 0; i < windows.length; i++) {
            if (!seens[windows[i]])
                res[idx++] = windows[i];
        }
        return res;
    }
}
