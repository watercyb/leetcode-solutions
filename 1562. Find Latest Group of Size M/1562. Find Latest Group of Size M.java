/*
 * Problem: 1562. Find Latest Group of Size M
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-latest-group-of-size-m/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int findLatestStep(int[] arr, int m) {
        if (m == arr.length)
            return m;
        int[] length = new int[arr.length + 2];
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            int l = length[arr[i] - 1];
            int r = length[arr[i] + 1];
            if (l == m || r == m)
                res = i;
            int len = l + r + 1;
            length[arr[i] - l] = len;
            length[arr[i] + r] = len;
        }
        return res;
    }
}
