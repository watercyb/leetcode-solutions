/*
 * Problem: 3394. Check if Grid can be Cut into Sections
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        long[] arr = new long[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            arr[i] = ((long) rectangles[i][0] << 30) + rectangles[i][2];
        }
        if (chk(arr))
            return true;
        for (int i = 0; i < rectangles.length; i++) {
            arr[i] = ((long) rectangles[i][1] << 30) + rectangles[i][3];
        }
        return chk(arr);
    }

    public boolean chk(long[] arr) {
        Arrays.sort(arr);
        int count = 0;
        long lim = 0;
        for (long h : arr) {
            long a = h >> 30;
            long b = h & ((1 << 30) - 1);
            if (a >= lim) {
                count++;
                lim = b;
            } else if (b > lim) {
                lim = b;
            }
        }
        return count >= 3;
    }
}
