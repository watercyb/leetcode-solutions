/*
 * Problem: 1992. Find All Groups of Farmland
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-all-groups-of-farmland/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> Li = new ArrayList<>();
        Li.add(new int[] { 0, 0, 0, 0 });
        int n = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    if (i != 0 && land[i - 1][j] > 0) {
                        land[i][j] = land[i - 1][j];
                    } else if (j != 0 && land[i][j - 1] > 0) {
                        land[i][j] = land[i][j - 1];
                    } else {
                        n++;
                        land[i][j] = n;
                        Li.add(new int[] { i, j, i, j });
                    }
                } else {
                    if (i != 0 && land[i - 1][j] > 0) {
                        int[] tmp = Li.get(land[i - 1][j]);
                        tmp[2] = i - 1;
                        tmp[3] = j;
                    } else if (j != 0 && land[i][j - 1] > 0) {
                        int[] tmp = Li.get(land[i][j - 1]);
                        tmp[2] = i;
                        tmp[3] = j - 1;
                    }
                }
            }
        }
        if (land[land.length - 1][land[0].length - 1] > 0) {
            int[] tmp = Li.get(land[land.length - 1][land[0].length - 1]);
            tmp[2] = land.length - 1;
            tmp[3] = land[0].length - 1;
        }
        int[][] res = new int[Li.size() - 1][4];
        for (int i = 0; i < res.length; i++) {
            res[i] = Li.get(i + 1);
        }
        return res;
    }
}
