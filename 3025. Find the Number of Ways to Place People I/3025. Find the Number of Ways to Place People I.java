/*
 * Problem: 3025. Find the Number of Ways to Place People I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        Integer[] minHeights = new Integer[51];
        int res = 0;
        int[] MQ = new int[51];
        int prv = 51;
        int idxMQ = 0;
        int idx = 0;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (y != prv) {
                idxMQ = 0;
                idx = 0;
                prv = y;
            } else {
                idxMQ = 1;
            }
            while (idx <= x) {
                if (minHeights[idx] != null) {
                    while (idxMQ > 0 && MQ[idxMQ - 1] >= minHeights[idx]) {
                        idxMQ--;
                    }
                    MQ[idxMQ++] = minHeights[idx];
                }
                idx++;
            }
            res += idxMQ;
            MQ[0] = y;
            minHeights[x] = y;
        }
        return res;
    }
}
