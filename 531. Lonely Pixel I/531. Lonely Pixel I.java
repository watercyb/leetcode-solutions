/*
 * Problem: 531. Lonely Pixel I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lonely-pixel-i/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findLonelyPixel(char[][] picture) {
        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];
        int res = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for (int i = 0; i < picture.length; i++) {
            if (rows[i] != 1)
                continue;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
