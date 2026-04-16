/*
 * Problem: 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] tmp : dist) {
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] >= distanceThreshold)
                    continue;
                for (int k = 0; k < n; k++) {
                    if (dist[i][k] < distanceThreshold && dist[i][j] + dist[i][k] < dist[j][k])
                        dist[j][k] = dist[i][j] + dist[i][k] ;
                }
            }
        }
        int[] min = { -1, Integer.MAX_VALUE };
        for (int i = 0; i < n; i++) {
            int tmpMin = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold)
                    tmpMin++;
            }
            if (tmpMin <= min[1])
                min = new int[] { i, tmpMin };
        }
        return min[0];
    }

}
