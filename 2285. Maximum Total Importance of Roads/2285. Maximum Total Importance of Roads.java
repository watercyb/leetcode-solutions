/*
 * Problem: 2285. Maximum Total Importance of Roads
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-importance-of-roads/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] connects = new int[n];
        for (int[] road : roads) {
            connects[road[0]]++;
            connects[road[1]]++;
        }
        int[] counts = new int[n];
        for (int connect : connects) {
            counts[connect]++;
        }
        long res = 0;
        long j = 1;
        for (int i = 0; i < counts.length; i++) {
            res += (2 * j + counts[i] - 1) * counts[i] / 2 * i;
            j += counts[i];
        }
        return res;
    }
}
