/*
 * Problem: 3243. Shortest Distance After Road Addition Queries I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] DP = new int[n];
        for (int i = 1; i < n; i++) {
            DP[i] = i;
        }
        List<Integer>[] lists = new ArrayList[n];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (DP[queries[i][1]] > DP[queries[i][0]] + 1) {
                DP[queries[i][1]] = DP[queries[i][0]] + 1;
                for (int j = queries[i][1]; j < n; j++) {
                    DP[j] = Math.min(DP[j - 1] + 1, DP[j]);
                    if (lists[j] != null) {
                        for (int idx : lists[j]) {
                            DP[idx] = Math.min(DP[j] + 1, DP[idx]);
                        }
                    }
                }
            }
            if (lists[queries[i][0]] == null)
                lists[queries[i][0]] = new ArrayList<>();
            lists[queries[i][0]].add(queries[i][1]);
            res[i] = DP[n - 1];
        }
        return res;
    }
}
