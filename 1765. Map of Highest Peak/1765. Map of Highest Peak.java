/*
 * Problem: 1765. Map of Highest Peak
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/map-of-highest-peak/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        if (isWater[0][0] != 1) {
            isWater[0][0] = Integer.MAX_VALUE / 2;
        } else {
            isWater[0][0] = 0;
        }
        for (int i = 1; i < isWater[0].length; i++) {
            if (isWater[0][i] != 1) {
                isWater[0][i] = isWater[0][i - 1] + 1;
            } else {
                isWater[0][i] = 0;
            }
        }
        for (int i = 1; i < isWater.length; i++) {
            if (isWater[i][0] != 1) {
                isWater[i][0] = isWater[i - 1][0] + 1;
            } else {
                isWater[i][0] = 0;
            }
            for (int j = 1; j < isWater[0].length; j++) {
                if (isWater[i][j] != 1) {
                    isWater[i][j] = Math.min(isWater[i - 1][j], isWater[i][j - 1]) + 1;
                } else {
                    isWater[i][j] = 0;
                }
            }
        }
        for (int i = isWater[0].length - 2; i >= 0; i--) {
            if (isWater[isWater.length - 1][i] != 0)
                isWater[isWater.length - 1][i] = Math.min(isWater[isWater.length - 1][i + 1] + 1,
                        isWater[isWater.length - 1][i]);
        }
        for (int i = isWater.length - 2; i >= 0; i--) {
            if (isWater[i][isWater[0].length - 1] != 0)
                isWater[i][isWater[0].length - 1] = Math.min(isWater[i + 1][isWater[0].length - 1] + 1,
                        isWater[i][isWater[0].length - 1]);
            for (int j = isWater[0].length - 2; j >= 0; j--) {
                if (isWater[i][j] != 0)
                    isWater[i][j] = Math.min(Math.min(isWater[i + 1][j], isWater[i][j + 1]) + 1, isWater[i][j]);
            }
        }
        return isWater;
    }
}
