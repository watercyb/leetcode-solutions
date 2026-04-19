/*
 * Problem: 1620. Coordinate With Maximum Network Quality
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/coordinate-with-maximum-network-quality/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxX = 0;
        int maxY = 0;
        for (int[] tower : towers) {
            maxX = Math.max(tower[0], maxX);
            maxY = Math.max(tower[1], maxY);
        }
        int max = 0;
        int x = 0;
        int y = 0;
        int r2 = radius * radius;
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                int sum = getSum(towers, i, j, r2);
                if (sum > max) {
                    max = sum;
                    x = i;
                    y = j;
                }
            }
        }
        return new int[] { x, y };
    }

    public int getSum(int[][] towers, int i, int j, int r2) {
        int res = 0;
        for (int[] tower : towers) {
            int d2 = getD2(tower[0], i, tower[1], j);
            if (d2 <= r2)
                res += (int) (tower[2] / (1 + Math.sqrt(d2)));
        }
        return res;
    }

    public int getD2(int a, int b, int c, int d) {
        return (a - b) * (a - b) + (c - d) * (c - d);
    }
}
