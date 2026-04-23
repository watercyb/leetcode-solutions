/*
 * Problem: 2021. Brightest Position on Street
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/brightest-position-on-street/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int brightestPosition(int[][] lights) {
        int[] left = new int[lights.length];
        int[] right = new int[lights.length];
        for (int i = 0; i < lights.length; i++) {
            left[i] = lights[i][0] - lights[i][1];
            right[i] = lights[i][0] + lights[i][1] + 1;
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int res = -1;
        int max = 0;
        int brightness = 0;
        int i = 0;
        int j = 0;
        while (i < left.length) {
            if (left[i] < right[j]) {
                brightness++;
                if (brightness > max) {
                    max = brightness;
                    res = left[i];
                }
                i++;
            } else if (left[i] > right[j]) {
                brightness--;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return res;
    }
}
