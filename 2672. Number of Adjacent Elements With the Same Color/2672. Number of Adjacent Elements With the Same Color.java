/*
 * Problem: 2672. Number of Adjacent Elements With the Same Color
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] arr = new int[n + 2];
        int count = 0;
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0] + 1;
            int color = queries[i][1];
            if (arr[idx] != color) {
                count += cmp(arr[idx - 1], arr[idx], color) + cmp(arr[idx + 1], arr[idx], color);
                arr[idx] = color;
            }
            res[i] = count;
        }
        return res;
    }

    public int cmp(int a, int b, int c) {
        if (a == 0)
            return 0;
        if (a == b)
            return -1;
        if (a == c)
            return 1;
        return 0;
    }
}
