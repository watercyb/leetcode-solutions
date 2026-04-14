/*
 * Problem: 1131. Maximum of Absolute Value Expression
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-of-absolute-value-expression/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[] mins = new int[4];
        Arrays.fill(mins, Integer.MAX_VALUE / 2);
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 1; k++) {
                    int idx = j * 2 + k;
                    int h = arr1[i] * (j * 2 - 1) + arr2[i] * (k * 2 - 1) + i;
                    if (mins[idx] >= h) {
                        mins[idx] = h;
                    } else if (h - mins[idx] > res) {
                        res = h - mins[idx];
                    }
                }
            }
        }
        return res;
    }
}
