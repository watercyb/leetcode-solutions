/*
 * Problem: 1042. Flower Planting With No Adjacent
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-array-for-maximum-sum/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[][] links = new int[n][3];
        boolean[][] seens = new boolean[n][4];
        int[] idx = new int[n];
        for (int[] path : paths) {
            links[path[0] - 1][idx[path[0] - 1]++] = path[1] - 1;
            links[path[1] - 1][idx[path[1] - 1]++] = path[0] - 1;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (res[i] == 0) {
                for (int j = 0; j < 4; j++) {
                    if (!seens[i][j]) {
                        res[i] = j + 1;
                        for (int k = 0; k < idx[i]; k++) {
                            seens[links[i][k]][j] = true;
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }
}
