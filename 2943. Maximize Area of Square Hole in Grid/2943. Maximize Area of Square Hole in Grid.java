/*
 * Problem: 2943. Maximize Area of Square Hole in Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maximizeSquareHoleArea(int m, int n, int[] hBars, int[] vBars) {
        int min = Math.min(getMax(hBars), getMax(vBars));
        return min * min;
    }

    public int getMax(int[] bars) {
        int max = 1;
        int len = 0;
        int prv = -1;
        Arrays.sort(bars);
        for (int i = 0; i < bars.length; i++) {
            if (bars[i] == prv + 1) {
                len++;
            } else {
                max = Math.max(max, len + 1);
                len = 1;
            }
            prv = bars[i];
        }
        return Math.max(max, len + 1);
    }
}
