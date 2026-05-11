/*
 * Problem: 3809. Best Reachable Tower
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/best-reachable-tower/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int[] res = { -1, -1 };
        int max = -1;
        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            int q = tower[2];
            if (Math.abs(x - center[0]) + Math.abs(y - center[1]) > radius)
                continue;
            if (q > max) {
                res[0] = x;
                res[1] = y;
                max = q;
            } else if (q == max) {
                if (x < res[0]) {
                    res[0] = x;
                    res[1] = y;
                    max = q;
                } else if (x == res[0]) {
                    if (y < res[1]) {
                        res[0] = x;
                        res[1] = y;
                        max = q;
                    }
                }
            }
        }
        return new int[] { res[0], res[1] };
    }
}
