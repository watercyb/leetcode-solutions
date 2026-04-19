/*
 * Problem: 1646. Get Maximum in Generated Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/get-maximum-in-generated-array/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int res = 1;
        for (int i = 1; 2 * i <= n; i++) {
            arr[2 * i] = arr[i];
            if (2 * i + 1 <= n) {
                arr[2 * i + 1] = arr[i] + arr[i + 1];
                res = Math.max(arr[i] + arr[i + 1], res);
            }
        }
        return res;
    }
}
