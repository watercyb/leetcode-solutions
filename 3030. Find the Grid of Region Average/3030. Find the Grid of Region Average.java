/*
 * Problem: 3030. Find the Grid of Region Average
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-grid-of-region-average/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int[][] sums = new int[image.length][image[0].length];
        int[][] counts = new int[image.length][image[0].length];
        for (int i = 1; i < image.length - 1; i++) {
            for (int j = 1; j < image[0].length - 1; j++) {
                int re = chk(image, i, j, threshold);
                if (re < 0)
                    continue;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        sums[k][l] += re;
                        counts[k][l]++;
                    }
                }
            }
        }
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < sums[0].length; j++) {
                if (counts[i][j] != 0) {
                    sums[i][j] /= counts[i][j];
                } else {
                    sums[i][j] = image[i][j];
                }
            }
        }
        return sums;
    }

    public int chk(int[][] image, int x, int y, int threshold) {
        int sum = image[x + 1][y + 1];
        for (int i = x - 1; i < x + 1; i++) {
            for (int j = y - 1; j < y + 1; j++) {
                if (Math.abs(image[i][j] - image[i + 1][j]) > threshold
                        || Math.abs(image[i][j] - image[i][j + 1]) > threshold)
                    return -1;
                sum += image[i][j];
            }
        }
        for (int i = x - 1; i < x + 1; i++) {
            if (Math.abs(image[i][y + 1] - image[i + 1][y + 1]) > threshold)
                return -1;
            sum += image[i][y + 1];
        }
        for (int j = y - 1; j < y + 1; j++) {
            if (Math.abs(image[x + 1][j] - image[x + 1][j + 1]) > threshold)
                return -1;
            sum += image[x + 1][j];
        }
        return sum / 9;
    }
}
