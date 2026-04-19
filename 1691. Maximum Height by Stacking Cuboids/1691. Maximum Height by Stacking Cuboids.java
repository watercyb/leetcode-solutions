/*
 * Problem: 1691. Maximum Height by Stacking Cuboids
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, (a, b) -> a[2] == b[2] ? a[1] == b[1] ? a[0] - b[0] : a[1] - b[1] : a[2] - b[2]);
        int[] DP = new int[cuboids.length];
        int res = 0;
        for (int i = 0; i < cuboids.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && DP[j] > DP[i])
                    DP[i] = DP[j];
            }
            DP[i] += cuboids[i][2];
            res = Math.max(DP[i], res);
        }
        return res;
    }
}
