/*
 * Problem: 302. Smallest Rectangle Enclosing Black Pixels
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int x1 = 0;
        int r = x;
        while (x1 < r) {
            int mid = (x1 + r) >>> 1;
            if (chkRow(image, mid)) {
                r = mid;
            } else {
                x1 = mid + 1;
            }
        }
        int x2 = x;
        r = image.length;
        while (x2 < r) {
            int mid = (x2 + r) >>> 1;
            if (!chkRow(image, mid)) {
                r = mid;
            } else {
                x2 = mid + 1;
            }
        }
        int y1 = 0;
        r = y;
        while (y1 < r) {
            int mid = (y1 + r) >>> 1;
            if (chkCol(image, mid)) {
                r = mid;
            } else {
                y1 = mid + 1;
            }
        }
        int y2 = y;
        r = image[0].length;
        while (y2 < r) {
            int mid = (y2 + r) >>> 1;
            if (!chkCol(image, mid)) {
                r = mid;
            } else {
                y2 = mid + 1;
            }
        }
        return (x2 - x1) * (y2 - y1);
    }

    public boolean chkRow(char[][] image, int i) {
        for (int j = 0; j < image[0].length; j++) {
            if (image[i][j] == '1')
                return true;
        }
        return false;
    }

    public boolean chkCol(char[][] image, int i) {
        for (int j = 0; j < image.length; j++) {
            if (image[j][i] == '1')
                return true;
        }
        return false;
    }
}
