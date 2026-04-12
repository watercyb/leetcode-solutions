/*
 * Problem: 1057. Campus Bikes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/campus-bikes/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]>[] distances = new ArrayList[2001];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                if (distances[distance] == null)
                    distances[distance] = new ArrayList<>();
                distances[distance].add(new int[] { i, j });
            }
        }
        boolean[] seens = new boolean[workers.length];
        boolean[] used = new boolean[bikes.length];
        int n = workers.length;
        int idx = 0;
        int[] res = new int[workers.length];
        while (n > 0) {
            if (distances[idx] != null) {
                Collections.sort(distances[idx], (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
                for (int[] distance : distances[idx]) {
                    if (!seens[distance[0]] && !used[distance[1]]) {
                        seens[distance[0]] = true;
                        used[distance[1]] = true;
                        res[distance[0]] = distance[1];
                        n--;
                    }
                }
            }
            idx++;
        }
        return res;
    }
}
