/*
 * Problem: 3143. Maximum Points Inside the Square
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-points-inside-the-square/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int[][] mins = new int[26][2];
        int[] dists = new int[points.length];
        for (int[] arr : mins) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for (int i = 0; i < points.length; i++) {
            dists[i] = getMax(points[i]);
            int idx = s.charAt(i) - 'a';
            if (dists[i] < mins[idx][0]) {
                mins[idx][1] = mins[idx][0];
                mins[idx][0] = dists[i];
            } else if (dists[i] < mins[idx][1]) {
                mins[idx][1] = dists[i];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mins.length; i++) {
            min = Math.min(min, mins[i][1]);
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            if (dists[i] < min)
                res++;
        }
        return res;
    }

    public int getMax(int[] arr) {
        return Math.max(Math.abs(arr[0]), Math.abs(arr[1]));
    }
}

