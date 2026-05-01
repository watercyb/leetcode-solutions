/*
 * Problem: 2865. Beautiful Towers I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/beautiful-towers-i/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int size = maxHeights.size();
        long[] sumLeft = new long[size];
        sumLeft[0] = maxHeights.get(0);
        int[] tmp = new int[size];
        tmp[0] = 0;
        int idx = 0;
        for (int i = 1; i < size; i++) {
            while (idx >= 0 && maxHeights.get(i) <= maxHeights.get(tmp[idx])) {
                idx--;
            }
            if (idx == -1) {
                sumLeft[i] = (long)(i + 1) * maxHeights.get(i);
            } else {
                sumLeft[i] = (long)(i - tmp[idx]) * maxHeights.get(i) + sumLeft[tmp[idx]];
            }
            tmp[++idx] = i;
        }
        long[] sumRight = new long[size];
        sumRight[size-1] = maxHeights.get(size - 1);
        tmp = new int[size];
        tmp[0] = size - 1;
        idx = 0;
        for (int i = size - 2; i >= 0; i--) {
            while (idx >= 0 && maxHeights.get(i) <= maxHeights.get(tmp[idx])) {
                idx--;
            }
            if (idx == -1) {
                sumRight[i] = (long)(size - i) * maxHeights.get(i);
            } else {
                sumRight[i] = (long)(tmp[idx] - i) * maxHeights.get(i) + sumRight[tmp[idx]];
            }
            tmp[++idx] = i;
        }
        long res = 0;
        for (int i = 0; i < size; i++) {
            res = Math.max(sumLeft[i] + sumRight[i] - maxHeights.get(i), res);
        }
        return res;
    }
}
