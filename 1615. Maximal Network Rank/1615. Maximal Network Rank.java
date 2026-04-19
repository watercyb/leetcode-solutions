/*
 * Problem: 1615. Maximal Network Rank
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximal-network-rank/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] cities = new boolean[n][n];
        int[] counts = new int[n];
        for (int i = 0; i < roads.length; i++) {
            counts[roads[i][0]]++;
            counts[roads[i][1]]++;
        }
        int[][] max = new int[2][2];
        for (int i = 0; i < n; i++) {
            if (counts[i] == max[0][0]) {
                max[0][1]++;
            } else if (counts[i] == max[1][0]) {
                max[1][1]++;
            } else if (counts[i] > max[0][0]) {
                max[1][0] = max[0][0];
                max[1][1] = max[0][1];
                max[0][0] = counts[i];
                max[0][1] = 1;
            } else if (counts[i] > max[1][0]) {
                max[1][0] = counts[i];
                max[1][1] = 1;
            }
        }
        if (max[0][1] > 1) {
            int count = 0;
            for (int i = 0; i < roads.length; i++) {
                if (counts[roads[i][0]] == max[0][0] && counts[roads[i][1]] == max[0][0])
                    count++;
            }
            int res = max[0][0] * 2;
            if (count == max[0][1] * (max[0][1] - 1) / 2)
                res--;
            return res;
        } else {
            int count = 0;
            for (int i = 0; i < roads.length; i++) {
                if ((counts[roads[i][0]] == max[0][0] && counts[roads[i][1]] == max[1][0])
                        || (counts[roads[i][0]] == max[1][0] && counts[roads[i][1]] == max[0][0]))
                    count++;
            }
            int res = max[0][0] + max[1][0];
            if (count == max[1][1])
                res--;
            return res;
        }
    }
}
