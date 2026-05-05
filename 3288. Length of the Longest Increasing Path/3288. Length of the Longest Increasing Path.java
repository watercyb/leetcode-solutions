/*
 * Problem: 3288. Length of the Longest Increasing Path
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/length-of-the-longest-increasing-path/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maxPathLength(int[][] coordinates, int k) {
        long target = ((long) coordinates[k][0] << 32) + Integer.MAX_VALUE - coordinates[k][1];
        long[] arr = new long[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            arr[i] = ((long) coordinates[i][0] << 32) + Integer.MAX_VALUE - coordinates[i][1];
        }
        Arrays.sort(arr);
        int[] DP = new int[coordinates.length];
        int res = 0;
        int i = 0;
        while (arr[i] != target) {
            int y = Integer.MAX_VALUE - (int) arr[i];
            int idx = binarySearch(DP, res, y);
            DP[idx] = y;
            if (idx == res)
                res++;
            i++;
        }
        res = binarySearch(DP, res, Integer.MAX_VALUE - (int) arr[i]) + 1;
        DP[res - 1] = Integer.MAX_VALUE - (int) arr[i];
        i++;
        int targetY = Integer.MAX_VALUE - (int) target;
        while (i < coordinates.length) {
            int y = Integer.MAX_VALUE - (int) arr[i];
            if (y > targetY) {
                int idx = binarySearch(DP, res, y);
                if (idx == res)
                    res++;
                DP[idx] = y;
            }
            i++;
        }
        return res;
    }

    public int binarySearch(int[] DP, int r, int num) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (DP[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
