/*
 * Problem: 533. Lonely Pixel II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lonely-pixel-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {

    public int findBlackPixel(char[][] picture, int target) {
        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < picture[0].length; i++) {
            int idx = -1;
            int count = 0;
            for (int j = 0; j < picture.length; j++) {
                if (picture[j][i] != 'B') continue;
                if (idx == -1) {
                    idx = j;
                    if (rows[j] ==target&& cols[i]==target) count = 1;
                } else {
                    for (int k = 0; k < picture[0].length; k++) {
                        if (picture[j][k] != picture[idx][k]) {
                            count = 0;
                            break;
                        }
                    }
                    if (count == 0) break;
                    count++;
                }
            }
            res += count;
        }
        return res;
    }
}

