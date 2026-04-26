/*
 * Problem: 2345. Finding the Number of Visible Mountains
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/finding-the-number-of-visible-mountains/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int visibleMountains(int[][] peaks) {
        Arrays.sort(peaks, (a, b) -> a[0] - b[0]);
        boolean[] blocked = new boolean[peaks.length];
        int max = 0;
        int idx = 0;
        for (int i = 0; i < peaks.length; i++) {
            int tmp = max - peaks[i][0] + idx;
            if (tmp >= peaks[i][1]) {
                blocked[i] = true;
            } else {
                max = peaks[i][1];
                idx = peaks[i][0];
            }
        }
        max = 0;
        idx = peaks[peaks.length - 1][0];
        for (int i = peaks.length - 1; i >= 0; i--) {
            int tmp = max - idx + peaks[i][0];
            if (tmp >= peaks[i][1]) {
                blocked[i] = true;
            } else {
                max = peaks[i][1];
                idx = peaks[i][0];
            }
        }
        int res = 0;
        for (boolean b : blocked) {
            if (!b)
                res++;
        }
        return res;
    }
}
