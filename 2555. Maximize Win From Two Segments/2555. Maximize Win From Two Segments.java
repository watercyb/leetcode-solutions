/*
 * Problem: 2555. Maximize Win From Two Segments
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-win-from-two-segments/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int[] lefts = new int[prizePositions.length + 1];
        int max = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < prizePositions.length; i++) {
            while (prizePositions[j] + k < prizePositions[i]) {
                j++;
            }
            res = Math.max(res, lefts[j] + i - j + 1);
            max = Math.max(max, i - j + 1);
            lefts[i + 1] = max;
        }
        return res;
    }
}
