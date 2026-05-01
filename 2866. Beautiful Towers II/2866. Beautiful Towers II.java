/*
 * Problem: 2866. Beautiful Towers II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/beautiful-towers-ii/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int size = maxHeights.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = maxHeights.get(i);
        }
        long[] sumLeft = new long[size];
        sumLeft[0] = arr[0];
        int[] tmp = new int[size];
        tmp[0] = 0;
        int idx = 0;
        for (int i = 1; i < size; i++) {
            while (idx >= 0 && arr[i] <= arr[tmp[idx]]) {
                idx--;
            }
            if (idx == -1) {
                sumLeft[i] = (long) (i + 1) * arr[i];
            } else {
                sumLeft[i] = (long) (i - tmp[idx]) * arr[i] + sumLeft[tmp[idx]];
            }
            tmp[++idx] = i;
        }
        long[] sumRight = new long[size];
        sumRight[size - 1] = arr[size-1];
        tmp = new int[size];
        tmp[0] = size - 1;
        idx = 0;
        long res = sumLeft[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            while (idx >= 0 && arr[i] <= arr[tmp[idx]]) {
                idx--;
            }
            if (idx == -1) {
                sumRight[i] = (long) (size - i) * arr[i];
            } else {
                sumRight[i] = (long) (tmp[idx] - i) * arr[i] + sumRight[tmp[idx]];
            }
            tmp[++idx] = i;
            res = Math.max(sumLeft[i] + sumRight[i] - arr[i], res);
        }
        return res;
    }
}
