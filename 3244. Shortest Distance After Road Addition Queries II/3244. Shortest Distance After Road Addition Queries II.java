/*
 * Problem: 3244. Shortest Distance After Road Addition Queries II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] arr = new int[n];
        int sum = n - 1;
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (arr[queries[i][0]] != -1 && arr[queries[i][0]] < queries[i][1]) {
                int j = queries[i][0];
                while (j < queries[i][1]) {
                    if (arr[j] == 0) {
                        arr[j] = -1;
                        sum--;
                        j++;
                    } else if (arr[j] > 0) {
                        j = arr[j];
                        sum--;
                    } else {
                        j++;
                    }
                }
                arr[queries[i][0]] = queries[i][1];
                sum++;
            }
            res[i] = sum;
        }
        return res;
    }
}
