/*
 * Problem: 2931. Maximum Spending After Buying Items
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-spending-after-buying-items/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long maxSpending(int[][] values) {
        int[] arr = new int[values.length * values[0].length];
        int idx = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                arr[idx++] = values[i][j];
            }
        }
        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += (long) arr[i] * (i + 1);
        }
        return res;
    }
}
